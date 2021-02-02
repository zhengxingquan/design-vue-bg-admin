package com.quan.core.service;


import com.quan.core.model.User;

import java.util.List;

/**
* @author mall
 */
public interface IUserService{

    void save(User u);

    List<User> list();

    User getById(Long id);

    void remove(Object o);
}
