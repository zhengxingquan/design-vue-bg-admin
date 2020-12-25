package com.quan.file.core.dao;

import com.quan.file.core.dto.FileQueryPageDTO;
import com.quan.file.core.model.FileInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author 作者 owen
 * @version 创建时间：2017年11月12日 上午22:57:51
 * oss上传存储db
 */
public interface FileDao {


    @Insert("insert into file_info(id, name, is_img, content_type, size, path, url, source, create_time) "
            + "values(#{id}, #{name}, #{isImg}, #{contentType}, #{size}, #{path}, #{url}, #{source}, #{createTime})")
    int save(FileInfo fileInfo);

    @Delete("delete from file_info where id = #{id}")
    int delete(String id);

    @Select("select id, name, is_img isImg, content_type contentType , size, path, url, source, create_time createTime from file_info t where t.id = #{id}")
    FileInfo findById(String id);

    int count(Map<String, Object> params);

    List<FileInfo> findList(@Param("data") FileQueryPageDTO data);
}
