package com.pangzi.vue_element_admin.controller;


import com.pangzi.vue_element_admin.VO.ResultData;
import com.pangzi.vue_element_admin.entity.ResponseStatus;
import com.pangzi.vue_element_admin.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping(value = "list/{type}")
    public ResultData getAuthList(@PathVariable("type") String type){
        ResultData resultData = new ResultData();
        try {
            resultData.setData(authService.getAuthList(type));
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("获取权限列表失败");
        }
        return resultData;
    }
}
