package com.quan.core.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.quan.core.common.model.BaseEntity;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/18
 * 描述：
 */
@Data
public class FileInfo extends BaseEntity {

    /***
     * md5字段
     */
    private String md5id;
    /***
     * 原始文件名
     */
    private String name;
    /***
     * 是否图片
     */
    private Boolean imgState;
    /***
     * 上传文件类型
     */
    private String contentType;
    /***
     * 文件大小
     */
    private long size;
    /***
     * 路径 （冗余字段）
     */
    private String path;
    /***
     * 访问路径
     */
    private String url;
    //	FileType字段
    /***
     * 文件类型 FileType
     */
    private String source;
    /**
     * 目录磁盘地址（本地文件）
     */
    @TableField(exist = false)
    private String pathDir;
}
