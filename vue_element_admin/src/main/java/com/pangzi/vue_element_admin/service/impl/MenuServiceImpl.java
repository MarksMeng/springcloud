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
        List<Menu> menuList = menuMapper.findMenuList();
        return menuListToTree(menuList);
    }

    private List<Menu> menuListToTree(List<Menu> menuList){
        List<Menu> menuTree = new ArrayList<>();
        for (Menu menu:menuList){
            if(menu.getParentId()==null){
                menuTree.add(menu);
            }else{
                for (Menu menu1:menuTree){
                    if(menu1.getId() == menu.getParentId()){
                        if(menu1.getChildren() == null){
                            List<Menu> menuTemp = new ArrayList<>();
                            menuTemp.add(menu);
                            menu1.setChildren(menuTemp);
                        }else{
                            menu1.getChildren().add(menu);
                        }

                    }
                }
            }
        }
        return menuTree;
    }
}
