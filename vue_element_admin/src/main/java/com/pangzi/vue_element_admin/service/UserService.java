package com.pangzi.vue_element_admin.service;

import com.github.pagehelper.PageInfo;
import com.pangzi.vue_element_admin.VO.UserListQueryVO;
import com.pangzi.vue_element_admin.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 获取所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 通过用户名获取单个用户信息
     * @param userName
     * @return
     */
    User findOneByUserName(String userName);

    /**
     * 通过用户名模糊查询用户列表 分页形式返回
     * @param userListQueryVO 分页查询参数
     * @return
     */
    PageInfo<User> findAllByUserName(UserListQueryVO userListQueryVO);
}
