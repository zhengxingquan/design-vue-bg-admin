package com.quan.core.common.mybatis.interceptor;

import lombok.Builder;
import lombok.Data;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/6
 * 描述：
 */
@Data
@Builder
public class FieldCache {

    private Object aClass;
    private Field field;
    private boolean hasAnnotation;
    private Annotation annotation;
}
