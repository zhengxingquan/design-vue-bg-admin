package com.quan.core.handler;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

/***
 * 管理员审批
 * @author zxq(956607644@qq.com)
 * @date 2020/12/3 23:07
 */
public class AdminTaskHandler implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("admin");
    }

}
