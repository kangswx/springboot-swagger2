package com.kangswx.springbootswagger2.service;

import com.kangswx.springbootswagger2.entity.User;

public interface UserService {

    User getByid(Integer id);

    int updateUser(User user);

    int deleteUserById(Integer id);

    int addUser(User user);
}
