package com.quan.core.common.mybatis.interceptor;

import com.google.common.collect.Lists;
import com.quan.core.common.annotation.batis.Prev;
import com.quan.core.common.annotation.batis.PrevDelete;
import com.quan.core.common.annotation.batis.PrevInsert;
import com.quan.core.common.annotation.batis.PrevUpdate;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/6
 * 描述：
 * <p>
 * 自动填充 修改人与 修改时间 插件
 * <p>
 * 参考：
 * https://blog.csdn.net/kokjuis/article/details/89202211
 */

@Intercepts({@Signature(type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class})})
@Component
public class AutoFillUpdateTimeInterceptor implements Interceptor {


    private final Map<Class, List<FieldCache>> fieldCacheObject = new ConcurrentHashMap<>(255);
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

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        // 获取 SQL
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        // 获取参数
        Object parameter = invocation.getArgs()[1];
        List<FieldCache> caches = fieldCacheObject.get(parameter.getClass());
        if (caches == null) {
            caches = getAnnotationField(parameter);
            fieldCacheObject.put(parameter.getClass() , caches);
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

    private List<FieldCache> getAnnotationField(Object parameter) {

        List<FieldCache> caches = new ArrayList<>();
        Class c = parameter.getClass();
        do {
            Field[] declaredFields = c.getDeclaredFields();
            if (declaredFields.length > 0) {

                Lists.newArrayList(declaredFields).stream().filter(
                        f -> {
                            Annotation[] anns = f.getAnnotations();
                            if (anns != null) {
                                return
                                        Lists.newArrayList(anns)
                                                .stream()
                                                .filter(ann -> autoScanAnnotation.contains(ann.getClass())).count() > 0;
                            }
                            return false;
                        }
                ).collect(Collectors.toList()).forEach(field -> {
                    caches.add(new FieldCache(field,true,field.getDeclaredAnnotation()));
                });
            }
            // 遍历父类
            c = c.getSuperclass();
        } while (c != null);

        return caches;

    }
}
