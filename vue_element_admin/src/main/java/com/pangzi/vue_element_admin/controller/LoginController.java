package com.pangzi.vue_element_admin.controller;

import com.pangzi.vue_element_admin.VO.ResultData;
import com.pangzi.vue_element_admin.entity.User;
import com.pangzi.vue_element_admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/getUser")
    public ResultData getUserByUserName(@RequestBody User user){
        ResultData resultData = new ResultData();
        User user1 = userService.findOneByUserName(user.getUserName());
        if(user1 == null){
            resultData.setCode("ERROR");
            resultData.setMessage("无此用户,请先开通账号");
        }else{
            if(user.getPassword().equals(user1.getPassword())){
                resultData.setData(user1);
            }else{
                resultData.setCode("ERROR");
                resultData.setMessage("密码错误");
            }
        }
        return resultData;
    }

    @GetMapping(value = "findAll")
    public ResultData getALlUser(){
        ResultData resultData = new ResultData();
        resultData.setData(userService.findAll());
        return resultData;
    }
}
