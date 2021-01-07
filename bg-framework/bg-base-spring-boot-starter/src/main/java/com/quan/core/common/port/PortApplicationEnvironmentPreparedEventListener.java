package com.quan.core.common.port;

import com.quan.core.common.port.props.RandomServerPortPropertySource;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 用于监听随机端口问题
 * Created by ace on 2017/7/8.
 */
@Component
public class PortApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        event.getEnvironment().getPropertySources().addLast(new RandomServerPortPropertySource());
    }
}
