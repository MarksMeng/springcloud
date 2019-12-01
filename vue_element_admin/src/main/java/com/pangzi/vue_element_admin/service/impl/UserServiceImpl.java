package com.pangzi.vue_element_admin.service.impl;

import com.pangzi.vue_element_admin.entity.User;
import com.pangzi.vue_element_admin.mapper.UserMapper;
import com.pangzi.vue_element_admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findOneByUserName(String userName) {
        return userMapper.findOneByUserName(userName);
    }
}
