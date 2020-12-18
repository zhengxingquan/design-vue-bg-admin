package com.quan.file.core.enume;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/18
 * 描述：文件类型
 */
public enum FileType {
    // 本地存储
    LOCAL(0),
    //fastdfs存储
    FAST_DFS(1);

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    FileType(int value) {
        this.value = value;
    }
}
