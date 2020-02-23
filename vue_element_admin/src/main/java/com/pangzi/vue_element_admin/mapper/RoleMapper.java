package com.pangzi.vue_element_admin.mapper;

import com.pangzi.vue_element_admin.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RoleMapper {

    List<Role> findRoleList();

    void insertOneRole(Role role);

    Role findRoleById(Integer id);

    void updateRoleInfoById(@Param("id") Integer id,@Param("roleName") String roleName,@Param("roleDesc") String roleDesc);

    void deleteRoleInfoById(Integer id);

    List<Role> findRoleOfUserByUserId(@Param("userId") Integer userId);
}
