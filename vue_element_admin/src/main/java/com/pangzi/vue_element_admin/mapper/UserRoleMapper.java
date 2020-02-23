package com.pangzi.vue_element_admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserRoleMapper {

    void deleteUserRoleByRid(@Param("rid")Integer rid);

    void updateRoleOfUser(@Param("id")Integer id,@Param("rid")Integer rid,@Param("oldRoleName")String oldRoleName);
}
