package com.pangzi.vue_element_admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.pangzi.vue_element_admin.entity.Auth;
import com.pangzi.vue_element_admin.entity.Role;
import com.pangzi.vue_element_admin.mapper.AuthMapper;
import com.pangzi.vue_element_admin.mapper.RoleAuthMapper;
import com.pangzi.vue_element_admin.mapper.RoleMapper;
import com.pangzi.vue_element_admin.mapper.UserRoleMapper;
import com.pangzi.vue_element_admin.service.RoleService;
import com.pangzi.vue_element_admin.util.AuthListToTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleAuthMapper roleAuthMapper;
    @Autowired
    private AuthMapper authMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> getRoleList() throws Exception{
        //获取所有的角色
        List<Role> roleList = roleMapper.findRoleList();
        for(Role role:roleList){
            //根据role的ID获取aid,在根据aid获取auth tree存入children里
            List<Integer> aidList = roleAuthMapper.findAidListByRid(role.getId());
            List<Auth> authList = new ArrayList<>();
            for(Integer aid: aidList){
                Auth auth = authMapper.findAuthById(aid);
                if(auth!=null){
                    authList.add(auth);
                }
            }
            role.setChildren(AuthListToTree.listToTree(authList));
        }
        return roleList;
    }

    @Override
    public void insertOneRole(Role role) throws Exception{
        roleMapper.insertOneRole(role);
    }

    @Override
    public Role findRoleInfoById(Integer id) throws Exception{
        Role role = roleMapper.findRoleById(id);
        List<Integer> aidList = roleAuthMapper.findAidListByRid(id);
        List<Auth> authList = new ArrayList<>();
        for(Integer aid: aidList){
            Auth auth = authMapper.findAuthById(aid);
            if(auth!=null){
                authList.add(auth);
            }
        }
        role.setChildren(AuthListToTree.listToTree(authList));
        return role;
    }

    @Override
    public void updateRoleInfoById(Integer id,Role role) throws Exception{
        roleMapper.updateRoleInfoById(id,role.getRoleName(),role.getRoleDesc());
    }

    @Override
    @Transactional
    public void deleteRoleInfoById(Integer id) throws Exception{
        //删除角色信息表
        roleMapper.deleteRoleInfoById(id);
        //删除角色-权限关联表
        roleAuthMapper.deleteRoleAuthByRid(id);
        //删除用户-角色关系表
        userRoleMapper.deleteUserRoleByRid(id);
    }

    @Override
    public void deleteAuthOfRoleByAuthIdAndRoleId(Integer rid,Integer aid) throws Exception{
        roleAuthMapper.deleteAuthOfRoleByAuthIdAndRoleId(rid,aid);
    }

    @Override
    @Transactional
    public void addAuthToRoleByRoleId(Integer rid,String aidsStr) throws Exception{
        String[] aidsList = aidsStr.split(",");

        //删除之前的授权
        roleAuthMapper.deleteRoleAuthByRid(rid);
        List<Integer> aids = new ArrayList<>();
        for(String aid:aidsList){
            aids.add(Integer.valueOf(aid));
        }
        roleAuthMapper.addAuthToRoleByRoleId(rid,aids);
    }


}
