package com.pangzi.vue_element_admin.mapper;

import com.pangzi.vue_element_admin.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MenuMapper {

    List<Menu> findMenuList();
}
