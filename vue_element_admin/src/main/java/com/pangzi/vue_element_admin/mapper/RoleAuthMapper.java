package com.pangzi.vue_element_admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RoleAuthMapper {

    List<Integer> findAidListByRid(@Param("rid")Integer rid);

    void deleteRoleAuthByRid(@Param("rid") Integer rid);

    void deleteAuthOfRoleByAuthIdAndRoleId(@Param("rid")Integer rid,@Param("aid")Integer aid);

    void addAuthToRoleByRoleId(@Param("rid")Integer rid,@Param("aids")List<Integer> aids);
}
