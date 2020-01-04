package com.pangzi.vue_element_admin.mapper;

import com.pangzi.vue_element_admin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    List<User> findAll();

    User findOneByUserName(@Param("userName") String userName);

    List<User> findAllByUserName(@Param("userName") String userName);

    void changeUserState(@Param("id") Integer id, @Param("state") Boolean state);

    void addOneUser(User user);

    User findUserById(Integer id);

    void updateUserInfoById(@Param("id") Integer id, @Param("email") String email,@Param("mobile") String mobile);

    void deleteUserById(Integer id);
}
