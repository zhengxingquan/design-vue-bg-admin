package com.quan.core.common.mybatis.interceptor;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/6
 * 描述：
 */
@Data
public class FieldCache {

    private final Field field;
    private final boolean hasAnnotation;
    private final Class annotationClazz;

    public FieldCache(Field field, boolean hasAnnotation, Class annotationClazz) {
        this.field = field;
        this.hasAnnotation = hasAnnotation;
        this.annotationClazz = annotationClazz;
    }
}
