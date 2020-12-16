package com.quan.common.handler.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.quan.common.auth.details.LoginAppUser;
import com.quan.common.util.SysUserUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/15
 * 描述：直接给entity的属性设置值!!!
 */
@Component
@Slf4j
public class CommonMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill createTime .... ");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        LoginAppUser loginAppUser = SysUserUtil.getLoginAppUser();
        if (loginAppUser != null) {
            this.strictInsertFill(metaObject, "creatorOptUserId", Long.class, loginAppUser.getId());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill updateTime ....");
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        LoginAppUser loginAppUser = SysUserUtil.getLoginAppUser();
        if (loginAppUser != null) {
            this.strictInsertFill(metaObject, "updateOptUserId", Long.class, loginAppUser.getId());
        }
    }
}
