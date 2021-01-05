package com.quan.core.adapater;

import com.quan.core.config.EventThreadConfig;
import com.quan.core.enums.AsyncEventGroupType;
import com.quan.core.event.IEventExecAdapter;
import com.quan.core.event.sync.ErrorAsyncEventHandle;
import com.quan.core.event.sync.IAsyncEvent;
import com.quan.core.event.sync.IAsyncEventHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 */
@Slf4j
@Component
public class AsyncQueueAdapter implements IEventExecAdapter<IAsyncEvent> {

    private final EventThreadConfig threadConfig;

    private final List<IAsyncEventHandle> eventHandleList;
    /**
     * 处理器索引
     */
    private final Map<Integer, IAsyncEventHandle> handleObject = new ConcurrentHashMap<>(255);
    /**
     * 队列索引 每一个 事件状态 维护一个队列
     */
    private final Map<Integer, Queue<IAsyncEvent>> queueObject = new ConcurrentHashMap<>(255);


    public AsyncQueueAdapter(EventThreadConfig threadConfig, List<IAsyncEventHandle> eventHandleList) {
        this.threadConfig = threadConfig;
        this.eventHandleList = eventHandleList;
    }

    @PostConstruct
    public void init() {
        for (final IAsyncEventHandle handle : eventHandleList) {
            handleObject.put(handle.getType().getCode(), handle);
            if (!queueObject.containsKey(handle.getType().getQueueType().getCode())) {
                queueObject.put(
                        handle.getType().getQueueType().getCode(),
                        createQueue(handle.getType().getQueueType()));
            }
        }
    }

    /***
     *   创建队列
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/5 22:45
     * @param asyncEventGroupType

     * @return java.util.Queue<com.quan.core.event.sync.IAsyncEvent>
     */
    private Queue<IAsyncEvent> createQueue(AsyncEventGroupType asyncEventGroupType) {
        return new ConcurrentLinkedQueue<>();
    }

    /**
     * 添加事件
     *
     * @param event 事件
     * @return 队列数量 若未找到队列返回null
     */
    public Integer add(IAsyncEvent event) {
        AsyncEventGroupType type = event.eventType().getQueueType();
        Queue<IAsyncEvent> queue = getQueue(type);
        if (Objects.isNull(queue)) {
            return null;
        }
        queue.add(event);
        return queue.size();
    }


    /***
     *  得到队列类型
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/5 22:45
     * @param asyncEventGroupType

     * @return java.util.Queue<com.quan.core.event.sync.IAsyncEvent>
     */
    private Queue<IAsyncEvent> getQueue(AsyncEventGroupType asyncEventGroupType) {
        Queue<IAsyncEvent> queue = queueObject.get(asyncEventGroupType.getCode());
        if (Objects.isNull(queue)) {
            log.error("queue type code is " + asyncEventGroupType.getCode() + " no found");
            return null;
        }
        return queue;
    }

    /***
     *   将首个元素从队列中弹出，如果队列是空的，就返回null
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/5 22:41
     * @param asyncEventGroupType

     * @return com.quan.core.event.sync.IAsyncEvent
     */
    public IAsyncEvent peek(AsyncEventGroupType asyncEventGroupType) {
        Queue<IAsyncEvent> queue = getQueue(asyncEventGroupType);
        if (Objects.isNull(queue)) {
            return null;
        }
        return queue.poll();
    }

    /**
     * 等待处理
     *
     * @param event 事件
     * @throws IOException 文件错误
     */
    @Override
    public void handle(IAsyncEvent event) {
        IAsyncEventHandle handle = new ErrorAsyncEventHandle();
        try {
            handle = handleObject.get(event.eventType().getCode());
            if (Objects.isNull(handle)) {
                throw new RuntimeException("no found handle,code is " + event.eventType().getCode());
            }
            handle.handle(event);
        } catch (Exception e) {
            log.error("process async queue error msg is " + e, e);
            handle.exceptionHandle(event, e);
        }
    }

}
