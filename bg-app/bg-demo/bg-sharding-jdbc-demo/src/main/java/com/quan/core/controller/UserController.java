package com.quan.core.controller;

import com.quan.core.model.User;
import com.quan.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mall
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 初始化数据
     */
    @GetMapping("/init")
    public String initDate() {
        String companyId;
        for (int i = 0; i < 100; i++) {
            User u = new User();
            if (i % 2 == 0) {
                companyId = "alibaba";
            } else {
                companyId = "baidu";
            }
            u.setCompanyId(companyId);
            u.setName(String.valueOf(i));
            userService.save(u);
        }
        return "success";
    }

    /**
     * 查询列表
     */
    @GetMapping("/")
    public List<User> list() {
        return userService.list();
    }

    /**
     * 查询单条记录
     */
    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return userService.getById(id);
    }

    /**
     * 清除数据
     */
    @GetMapping("/clean")
    public String clean() {
        userService.remove(null);
        return "success";
    }
}
