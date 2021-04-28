package com.quan.core.cache;

import com.quan.core.common.DetailResponse;
import com.quan.core.common.FastOcpRabbitMqConstants;
import com.quan.core.producer.MessageSender;
import com.quan.core.producer.MessageWithTime;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;


/***
 * 重试缓存类
 *
 * @author zxq(956607644@qq.com)
 * @date 2021/4/28 18:06
 * @return
 */
@Slf4j
public final class RetryCache {
    private MessageSender sender;
    private boolean stop = false;
    private Map<Long, MessageWithTime> map = new ConcurrentSkipListMap<>();
    private AtomicLong id = new AtomicLong();

    public void setSender(MessageSender sender) {
        this.sender = sender;
        startRetry();
    }

    public long generateId() {
        return id.incrementAndGet();
    }

    public void add(MessageWithTime messageWithTime) {
        map.putIfAbsent(messageWithTime.getId(), messageWithTime);
    }

    public void del(long id) {
        map.remove(id);
    }

    private void startRetry() {
        new Thread(() -> {
            while (!stop) {
                try {
                    Thread.sleep(FastOcpRabbitMqConstants.RETRY_TIME_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                long now = System.currentTimeMillis();

                for (Map.Entry<Long, MessageWithTime> entry : map.entrySet()) {
                    MessageWithTime messageWithTime = entry.getValue();

                    if (null != messageWithTime) {
                        if (messageWithTime.getTime() + 3 * FastOcpRabbitMqConstants.VALID_TIME < now) {
                            log.info("send message {} failed after 3 min ", messageWithTime);
                            del(entry.getKey());
                        } else if (messageWithTime.getTime() + FastOcpRabbitMqConstants.VALID_TIME < now) {
                            DetailResponse res = sender.send(messageWithTime);

                            if (!res.isIfSuccess()) {
                                log.info("retry send message failed {} errMsg {}", messageWithTime, res.getErrMsg());
                            }
                        }
                    }
                }
            }
        }).start();
    }
}