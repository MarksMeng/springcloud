package com.pangzi.vue_element_admin.util;

import com.pangzi.vue_element_admin.entity.Auth;

import java.util.ArrayList;
import java.util.List;

public class AuthListToTree {

    public static List<Auth> listToTree(List<Auth> authList){
        List<Auth> authTree = new ArrayList<Auth>();
        for(Auth auth: authList){
            if("0".equalsIgnoreCase(auth.getPid().toString()) || 0== auth.getPid() || auth.getPid()==null){
                authTree.add(findChildren(auth,authList));
            }
        }
        return authTree;
    }

    public static Auth findChildren(Auth auth,List<Auth> authList){
        auth.setChildren(new ArrayList<Auth>());
        for (Auth childredAuth: authList){
            if(auth.getId() == childredAuth.getPid()){
                if(auth.getChildren() == null){
                    auth.setChildren(new ArrayList<>());
                }
                auth.getChildren().add(findChildren(childredAuth,authList));
            }
        }
        return auth;
    }
}
