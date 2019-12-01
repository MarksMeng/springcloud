package com.pangzi.vue_element_admin.service;

import com.pangzi.vue_element_admin.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOneByUserName(String userName);
}
