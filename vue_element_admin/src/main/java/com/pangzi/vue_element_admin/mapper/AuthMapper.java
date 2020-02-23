package com.pangzi.vue_element_admin.mapper;

import com.pangzi.vue_element_admin.entity.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AuthMapper {

    List<Auth> findAuthList();

    Auth findAuthById(@Param("id") Integer id);
}
