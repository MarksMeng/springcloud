package com.pangzi.vue_element_admin.service;

import com.pangzi.vue_element_admin.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRoleList() throws Exception;

    void insertOneRole(Role role) throws Exception;

    Role findRoleInfoById(Integer id) throws Exception;

    void updateRoleInfoById(Integer id, Role role) throws Exception;

    void deleteRoleInfoById(Integer id) throws Exception;

    void deleteAuthOfRoleByAuthIdAndRoleId(Integer rid,Integer aid) throws Exception;

    void addAuthToRoleByRoleId(Integer rid,String aidsStr) throws Exception;
}
