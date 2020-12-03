package com.quan.workflow.core.handler;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

/***
 *   
 * @author zxq(956607644@qq.com)  
 * @date 2020/12/3 23:07
 * @return
 */  
public class StartTaskListener implements TaskListener {
    
    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("调用了任务监听器");
    }
}
