package com.pangzi.vue_element_admin.controller;

import com.pangzi.vue_element_admin.VO.ResultData;
import com.pangzi.vue_element_admin.VO.UserListQueryVO;
import com.pangzi.vue_element_admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "users")
    public ResultData getUsersByPage(UserListQueryVO userListQueryVO){
        ResultData resultData = new ResultData();
        resultData.setData(userService.findAllByUserName(userListQueryVO));
        return resultData;
    }
}
