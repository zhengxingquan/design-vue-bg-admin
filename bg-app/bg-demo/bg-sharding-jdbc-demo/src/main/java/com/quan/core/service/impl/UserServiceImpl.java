package com.quan.core.service.impl;

import com.quan.core.model.User;
import com.quan.core.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mall
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public void save(User u) {

    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public void remove(Object o) {

    }
}