package com.pangzi.vue_element_admin.service;

import com.pangzi.vue_element_admin.entity.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> findMenuTree();
}
