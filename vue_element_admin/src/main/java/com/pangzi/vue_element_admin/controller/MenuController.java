package com.pangzi.vue_element_admin.controller;

import com.pangzi.vue_element_admin.VO.ResultData;
import com.pangzi.vue_element_admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "tree")
    public ResultData getMenuTree(){
        ResultData resultData = new ResultData();
        resultData.setData(menuService.findMenuTree());
        return resultData;
    }
}
