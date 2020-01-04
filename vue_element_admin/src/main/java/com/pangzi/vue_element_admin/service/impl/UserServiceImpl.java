package com.pangzi.vue_element_admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pangzi.vue_element_admin.VO.UserListQueryVO;
import com.pangzi.vue_element_admin.VO.UserVO;
import com.pangzi.vue_element_admin.entity.User;
import com.pangzi.vue_element_admin.mapper.UserMapper;
import com.pangzi.vue_element_admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

    @Override
    public PageInfo<User> findAllByUserName(UserListQueryVO userListQueryVO) {
        PageHelper.startPage(userListQueryVO.getPageNum(), userListQueryVO.getPageSize());
        List<User> userList = userMapper.findAllByUserName(userListQueryVO.getQuery());
        return new PageInfo<User>(userList);
    }

    @Override
    public void changeUserState(Integer id, Boolean state) throws Exception{
        userMapper.changeUserState(id,state);
    }

    @Override
    public void addUser(UserVO userVO) throws Exception{
        User user = new User();
        BeanUtils.copyProperties(userVO,user);
        user.setState(true);
        userMapper.addOneUser(user);
    }

    @Override
    public User getUserById(Integer id) throws Exception{
        return userMapper.findUserById(id);
    }

    @Override
    public void updateUserInfoById(Integer id, String email,String mobile){
        userMapper.updateUserInfoById(id,email,mobile);
    }

    @Override
    public void deleteUserById(Integer id){
        userMapper.deleteUserById(id);
    }
}
