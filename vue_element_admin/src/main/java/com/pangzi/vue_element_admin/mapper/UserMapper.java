package com.pangzi.vue_element_admin.mapper;

import com.pangzi.vue_element_admin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    List<User> findAll();

    User findOneByUserName(String userName);
}
