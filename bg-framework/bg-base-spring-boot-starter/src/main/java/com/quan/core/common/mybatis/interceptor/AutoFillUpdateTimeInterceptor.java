package com.quan.core.common.mybatis.interceptor;

import cn.hutool.core.util.ReflectUtil;
import com.google.common.collect.Lists;
import com.quan.core.common.annotation.batis.Prev;
import com.quan.core.common.annotation.batis.PrevDelete;
import com.quan.core.common.annotation.batis.PrevInsert;
import com.quan.core.common.annotation.batis.PrevUpdate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/6
 * 描述：
 * <p>
 * 自动填充 修改人与 修改时间 插件
 * <p>
 * 参考：
 * https://blog.csdn.net/kokjuis/article/details/89202211
 * <p>
 * 四大对象是指：executor, statementHandler,parameterHandler，resultHandler对象
 */

@Intercepts({@Signature(type = ParameterHandler.class,
        method = "setParameters",
        args = {PreparedStatement.class})})
//@Component
@Slf4j
public class AutoFillUpdateTimeInterceptor implements Interceptor {


    private static final String PARAM_KEY = "tenantId";

    private final Map<String, List<FieldCache>> fieldCacheObject = new ConcurrentHashMap<>(255);
    private final List<Class> autoScanAnnotation = new ArrayList<>(10);

    @PostConstruct
    public void init() {
        autoScanAnnotation.add(Prev.class);
        autoScanAnnotation.add(PrevInsert.class);
        autoScanAnnotation.add(PrevDelete.class);
        autoScanAnnotation.add(PrevUpdate.class);
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

//        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        // 获取 SQL
//        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        // 获取参数
//        Object parameter = invocation.getArgs()[1];
//        List<FieldCache> caches = fieldCacheObject.get(parameter.getClass());
//        if (caches == null) {
//            caches = getAnnotationField(parameter);
//            fieldCacheObject.put(parameter.getClass(), caches);
//        }

        //拦截 ParameterHandler 的 setParameters 方法 动态设置参数
        if (invocation.getTarget() instanceof ParameterHandler) {
            return invokeSetParameter(invocation);
        }
        // TODO  遍历注解 插入数据
//        caches
        // 获取私有成员变量
        // 放开执行后面的数据记录
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }


    private Object invokeSetParameter(Invocation invocation) throws Exception {

        ParameterHandler parameterHandler = (ParameterHandler) invocation.getTarget();
        PreparedStatement ps = (PreparedStatement) invocation.getArgs()[0];

        // 反射获取 参数对像
        Field parameterField = parameterHandler.getClass().getDeclaredField("parameterObject");
        parameterField.setAccessible(true);
        Object parameterObject = parameterField.get(parameterHandler);
        List<FieldCache> caches = fieldCacheObject.get(parameterObject.getClass().getName());
        if (caches == null) {
            // 判断注解
            caches = getAnnotationField(parameterObject);
            fieldCacheObject.put(parameterObject.getClass().getName(), caches);
        }
        //
//        // 改写参数
        processParam(parameterObject,caches);
//
//        // 改写的参数设置到原parameterHandler对象
        parameterField.set(parameterHandler, parameterObject);
        parameterHandler.setParameters(ps);

        // 反射设值


        // 反射获取 BoundSql 对象，此对象包含生成的sql和sql的参数map映射
//        Field boundSqlField = parameterHandler.getClass().getDeclaredField("boundSql");
//        boundSqlField.setAccessible(true);
//        BoundSql boundSql = (BoundSql) boundSqlField.get(parameterHandler);
//
//        List<String> paramNames = new ArrayList<>();
//        // 若参数映射没有包含的key直接返回
//        boolean hasKey = hasParamKey(paramNames, boundSql.getParameterMappings());
//        if (!hasKey) {
//            return invocation.proceed();
//        }
//
//        // 反射获取 参数对像
//        Field parameterField = parameterHandler.getClass().getDeclaredField("parameterObject");
//        parameterField.setAccessible(true);
//        Object parameterObject = parameterField.get(parameterHandler);
//
//        // 改写参数
//        parameterObject = processSingle(parameterObject, paramNames);
//
//        // 改写的参数设置到原parameterHandler对象
//        parameterField.set(parameterHandler, parameterObject);
//        parameterHandler.setParameters(ps);

        return invocation.proceed();
    }


    private void processParam(Object parameterObject ,List<FieldCache> caches) throws IllegalAccessException, InvocationTargetException {
        // 处理参数对象  如果是 map 且map的key 中没有 tenantId，添加到参数map中
        // 如果参数是bean，反射设置值
        if (parameterObject instanceof Map) {
            ((Map) parameterObject).putIfAbsent(PARAM_KEY, 1L);
        } else {
            List<FieldCache> cacheList =  Lists.newArrayList(caches);
            for (FieldCache field : cacheList) {
                // 判断是否是prevInsert
                Annotation annotation = field.getAnnotation();
                if (annotation instanceof PrevInsert) {
                    PrevInsert prevInsert = ((PrevInsert) annotation);
                    if (prevInsert.now()) {
                        PropertyDescriptor ps = BeanUtils.getPropertyDescriptor(parameterObject.getClass(), field.getField().getName());
                        if (ps != null && ps.getReadMethod() != null && ps.getWriteMethod() != null) {
                            Object value = ps.getReadMethod().invoke(parameterObject);
                            value = null;
                            if (value == null) {
                                ps.getWriteMethod().invoke(parameterObject, new Date());
                            }
                        }
                    }
                    if (prevInsert.nullEffective()) {

                    }
                    if (prevInsert.uu32()) {

                    }
                }
            }

        }
    }

    private List<FieldCache> getAnnotationField(Object parameter) {
        List<FieldCache> caches = new ArrayList<>();
        Class c = parameter.getClass();
        do {
            Field[] declaredFields = c.getDeclaredFields();
            if (declaredFields.length > 0) {

                for (Field f : declaredFields) {
                    Annotation[] anns = f.getAnnotations();
                    if (anns.length > 0) {
                        for (Annotation ann : anns) {
                            // 寻找注解（判断注解类型）
                            if (autoScanAnnotation.contains(ann.annotationType())) {
                                caches.add(FieldCache.builder()
                                        .aClass(parameter)
                                        .field(f)
                                        .hasAnnotation(true)
                                        .annotation(ann)
                                        .build());
                            }
                        }
                    }
                }
            }
            // 遍历父类
            c = c.getSuperclass();
        } while (c != null);

        return caches;

    }
}
