package com.quan.core.dao;

import com.quan.core.BgPlatformCoreUserApplication;
import com.quan.core.constant.model.SysMenu;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BgPlatformCoreUserApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// 配置启动类
public class SysMenuDaoTest {

    @Resource
    private SysMenuDao sysMenuDao;

    @Test
    public void testFindMenuById() {

        SysMenu sysMenu = sysMenuDao.findById(1L);
        log.info("查询菜单：" + sysMenu);

    }

    @Test
    public void tt() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user = User
                .withUsername("admin1")
                .password(passwordEncoder.encode("admin"))
                .roles("USER")
                .build();

        System.out.println(user.getPassword());
    }

}
