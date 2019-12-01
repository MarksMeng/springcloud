package com.pangzi.vue_element_admin.service.impl;

import com.pangzi.vue_element_admin.entity.Menu;
import com.pangzi.vue_element_admin.mapper.MenuMapper;
import com.pangzi.vue_element_admin.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findMenuTree() {
        return menuMapper.findMenuList();
    }
}
