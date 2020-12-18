package com.quan.file.core.service.impl;

import com.quan.common.annotation.PageQuery;
import com.quan.common.web.PageResult;
import com.quan.file.core.dao.FileDao;
import com.quan.file.core.dto.FileQueryPageDTO;
import com.quan.file.core.enume.FileType;
import com.quan.file.core.model.FileInfo;
import com.quan.file.core.request.FileQueryPageRequest;
import com.quan.file.core.service.FileService;
import com.quan.file.core.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/***
 *  抽象的 File 服务类 对象
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/18 15:09
 */
@Slf4j
public abstract class AbstractFileService implements FileService {


    protected abstract FileDao getFileDao();

    /**
     * 上传文件类型
     *
     * @return
     */
    protected abstract FileType fileType();

    /**
     * 上传文件
     *
     * @param file
     * @param fileInfo
     */
    protected abstract void uploadFile(MultipartFile file, FileInfo fileInfo) throws Exception;

    /**
     * 删除文件资源
     *
     * @param fileInfo
     * @return
     */
    protected abstract boolean deleteFile(FileInfo fileInfo);

    /**
     * 上传大文件
     * 分片上传 每片一个临时文件
     *
     * @param file
     * @return
     */
    protected abstract void chunkFile(String guid, Integer chunk, MultipartFile file, Integer chunks, String filePath) throws Exception;

    /**
     * 合并分片文件
     * 每一个小片合并一个完整文件
     *
     * @param fileName
     * @return
     */
    protected abstract FileInfo mergeFile(String guid, String fileName, String filePath) throws Exception;

    @Override
    public FileInfo upload(MultipartFile file) throws Exception {
        FileInfo fileInfo = FileUtil.getFileInfo(file);
        FileInfo oldFileInfo = getFileDao().findById(fileInfo.getId());
        if (oldFileInfo != null) {
            return oldFileInfo;
        }

        if (!fileInfo.getName().contains(".")) {
            throw new IllegalArgumentException("缺少后缀名");
        }

        // 实现
        uploadFile(file, fileInfo);

        fileInfo.setSource(fileType().name());// 设置文件来源
        getFileDao().save(fileInfo);// 将文件信息保存到数据库

        log.info("上传文件：{}", fileInfo);

        return fileInfo;
    }


    @Override
    public void delete(FileInfo fileInfo) {
        deleteFile(fileInfo);
        // 执行删除数据库操作
        getFileDao().delete(fileInfo.getId());
        log.info("删除文件：{}", fileInfo);
    }

    @Override
    public FileInfo getById(String id) {
        return getFileDao().findById(id);
    }

    @Override
    @PageQuery
    public PageResult<FileInfo> findList(FileQueryPageRequest req) {
        FileQueryPageDTO data = new FileQueryPageDTO();
        data.setPageNumber(req.getPageNumber());
        data.setPageSize(req.getPageSize());
        return (PageResult<FileInfo>) getFileDao().findList(data);
    }

    @Override
    public void unZip(String filePath, String descDir) throws RuntimeException {

    }


    @Override
    public void chunk(String guid, Integer chunk, MultipartFile file, Integer chunks, String filePath) throws Exception {
        // TODO: 2020/6/16  分片提交
        chunkFile(guid, chunk, file, chunks, filePath);
    }

    @Override
    public FileInfo merge(String guid, String fileName, String filePath) throws Exception {
        return mergeFile(guid, fileName, filePath);
    }

    @Override
    public void uploadError(String guid, String fileName, String filePath) throws Exception {
        File parentFileDir = new File(filePath + File.separator + guid);
        try {
        } finally {
            // 删除临时目录中的分片文件
            try {
                FileUtils.deleteDirectory(parentFileDir);
            } catch (IOException e) {
                log.error("删除临时目录中的分片文件 失败", e);
            }
        }
    }
}
