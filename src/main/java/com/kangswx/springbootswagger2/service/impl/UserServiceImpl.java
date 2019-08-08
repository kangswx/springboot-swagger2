package com.kangswx.springbootswagger2.service.impl;

import com.kangswx.springbootswagger2.entity.User;
import com.kangswx.springbootswagger2.mapper.UserMapper;
import com.kangswx.springbootswagger2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByid(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

}
