package com.quan.core.model;

import com.quan.core.constant.model.BaseEntity;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/18
 * 描述：
 */
@Data
public class FileExtend extends BaseEntity {

    //  md5字段
    private String md5Id;
    // 文件分片id
    private String guid;
    //  原始文件名
    private String name;
    //	文件大小
    private long size;
    //  冗余字段
    private String path;
    //	oss访问路径 oss需要设置公共读
    private String url;
    //	FileType字段
    private String source;
    //	主文件id
    private String fileId;
}
