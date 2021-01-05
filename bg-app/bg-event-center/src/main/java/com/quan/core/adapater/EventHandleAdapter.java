package com.quan.core.adapater;

import com.quan.core.event.IEvent;
import com.quan.core.event.IEventExecAdapter;
import com.quan.core.event.IEventHandle;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 */
@Slf4j
@Component
public class EventHandleAdapter implements ApplicationContextAware, IEventExecAdapter<IEvent> {


    // 事件容器
    private final Map<Class<? extends IEvent>, List<IEventHandle>>
            handleAdapterMap = new ConcurrentHashMap<>(50);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 得到 所有的 事件执行器
        Map<String, IEventHandle> handleMap = applicationContext.getBeansOfType(IEventHandle.class);
        if (MapUtils.isEmpty(handleMap)) {
            log.warn("no found eventHandle");
            return;
        }
        // 放入集合中
        for (IEventHandle handle : handleMap.values()) {
            handleAdapterMap.putIfAbsent(handle.eventClass(), new ArrayList<>());
            log.info("event handle register,event is {},handle is {}", handle.eventClass().getSimpleName(), handle.getClass().getSimpleName());
            handleAdapterMap.get(handle.eventClass()).add(handle);
        }
    }


    @Override
    public void handle(IEvent event) {
        List<IEventHandle> handles = handleAdapterMap.get(event.getClass());
        if (CollectionUtils.isEmpty(handles)) {
            return;
        }
        for (IEventHandle handle : handles) {
            try {
                handle.handle(event);
            } catch (Exception e) {
                handle.exceptionHandle(event, e);
            }
        }
    }
}
