package com.quan.file.core.service;

import com.quan.common.web.PageResult;
import com.quan.file.core.model.FileInfo;
import com.quan.file.core.request.FileQueryPageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


/***
 *   文件service 接口 方便子类实现
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/18 15:00
 */
public interface FileService {

    FileInfo upload(MultipartFile file) throws Exception;

    void delete(FileInfo fileInfo);

    FileInfo getById(String id);

    PageResult<FileInfo> findList(FileQueryPageRequest params);

    void unZip(String filePath, String descDir) throws RuntimeException;

    void chunk(String guid, Integer chunk, MultipartFile file, Integer chunks, String filePath) throws Exception;

    FileInfo merge(String guid, String fileName, String filePath) throws Exception;

    void uploadError(String guid, String fileName, String filePath) throws Exception;

}
