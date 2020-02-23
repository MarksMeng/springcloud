package com.pangzi.vue_element_admin.service;

import com.pangzi.vue_element_admin.entity.Auth;

import java.util.List;

public interface AuthService {

    List<Auth> getAuthList(String type);

}
