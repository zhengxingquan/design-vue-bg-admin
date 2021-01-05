package com.quan.core.executor;

import com.quan.core.adapater.AsyncQueueAdapter;
import com.quan.core.config.EventThreadConfig;
import com.quan.core.enums.AsyncEventGroupType;
import com.quan.core.event.sync.IAsyncEvent;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 */

@Slf4j
@Service
public class EventExecuteService {

    private final EventThreadConfig threadConfig;

    private final AsyncQueueAdapter adapter;

    public EventExecuteService(EventThreadConfig threadConfig, AsyncQueueAdapter adapter) {
        this.threadConfig = threadConfig;
        this.adapter = adapter;
    }

    @PostConstruct
    public void init() {
        ExecutorService processEventPool = createProcessEventPool();
        ExecutorService eventReadPool = createEventReadPool();
        initProcess(processEventPool, eventReadPool);
    }

    private void initProcess(ExecutorService processEventPool, ExecutorService eventReadPool) {
        for (final AsyncEventGroupType value : AsyncEventGroupType.values()) {
            eventReadPool.submit(() -> {
                while (true) {
                    try {
                        readEvent(processEventPool, value);
                    } catch (Exception e) {
                        log.info("queue {} get event error", value.getCode());
                    }
                }
            });
        }
    }

    private void readEvent(ExecutorService processEventPool, AsyncEventGroupType value) throws InterruptedException {
        IAsyncEvent event = adapter.peek(value);
        if (Objects.isNull(event)) {
            Thread.sleep(1000);
            return;
        }
        handleEvent(processEventPool, event);
    }

    private void handleEvent(ExecutorService processEventPool, IAsyncEvent event) {
        processEventPool.submit(() -> {
            try {
                MDC.put("REQ_ID", event.getEventCode());
                String name = Thread.currentThread().getName();
                if (StringUtils.isBlank(name)) {
                    name = String.valueOf(Thread.currentThread().getId());
                }
                MDC.put("THREAD_ID", name);
                adapter.handle(event);
            } catch (Exception e) {
                log.info("adapter peekHandle error,msg is " + e, e);
            }
        });
    }

    /***
     *  创建 读数据线程池
     * @author zxq(956607644@qq.com)  
     * @date 2021/1/5 22:39
     * @param 
    
     * @return java.util.concurrent.ExecutorService  
     */  
    private ExecutorService createEventReadPool() {
        return
                new ThreadPoolExecutor(

                        AsyncEventGroupType.values().length,
                        AsyncEventGroupType.values().length,
                        1, TimeUnit.MINUTES,
                        new LinkedBlockingQueue<>(1),
                        new ThreadFactory() {
                            
                            private AtomicInteger atomicInteger = new AtomicInteger(0);

                            @Override
                            public Thread newThread(Runnable r) {
                                int counter = atomicInteger.incrementAndGet();
                                String name = "event_read_" + counter;
                                return new Thread(r, name);
                            }
                        });
    }

    /***
     *  创建线程池
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/5 22:38
     * @param

     * @return java.util.concurrent.ExecutorService
     */
    private ExecutorService createProcessEventPool() {
        int keepAlive = threadConfig.getKeepAlive();
        ThreadFactory processFactory = new ThreadFactory() {

            private AtomicInteger atomicInteger = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                int counter = atomicInteger.incrementAndGet();
                String name = "event_process_" + counter;
                return new Thread(r, name);
            }
        };
        return new ThreadPoolExecutor(
                threadConfig.getCoreSize(),
                threadConfig.getMaxSize(),
                keepAlive,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),
                processFactory,
                new EventExecutorRejectHandle());
    }
}
