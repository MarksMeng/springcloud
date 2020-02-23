package com.pangzi.vue_element_admin.service.impl;

import com.pangzi.vue_element_admin.entity.Auth;
import com.pangzi.vue_element_admin.mapper.AuthMapper;
import com.pangzi.vue_element_admin.service.AuthService;
import com.pangzi.vue_element_admin.util.AuthListToTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<Auth> getAuthList(String type){
        List<Auth> authList = authMapper.findAuthList();
        if("tree".equalsIgnoreCase(type)){
            return AuthListToTree.listToTree(authList);
        }else{
            return authList;
        }
    }




}
