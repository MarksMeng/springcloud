package com.pangzi.vue_element_admin.service;

import com.github.pagehelper.PageInfo;
import com.pangzi.vue_element_admin.VO.UserListQueryVO;
import com.pangzi.vue_element_admin.VO.UserVO;
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

    /**
     * 更新user的state值
     * @param id
     * @param state
     */
    void changeUserState(Integer id, Boolean state) throws Exception;

    /**
     * 添加用户
     * @param userVO
     * @throws Exception
     */
    void addUser(UserVO userVO) throws Exception;

    /**
     * 根据用户ID获取用户信息
     * @param id
     * @return
     * @throws Exception
     */
    User getUserById(Integer id) throws Exception;

    /**
     * 根据ID更新用户的email和mobile
     * @param id
     * @param email
     * @param mobile
     * @throws Exception
     */
    void updateUserInfoById(Integer id, String email, String mobile) throws Exception;

    /**
     * 根据用户删除用户
     * @param id
     */
    void deleteUserById(Integer id);
}
