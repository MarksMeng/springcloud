package com.pangzi.vue_element_admin.controller;

import com.pangzi.vue_element_admin.VO.ResultData;
import com.pangzi.vue_element_admin.VO.RoleVo;
import com.pangzi.vue_element_admin.VO.UserVO;
import com.pangzi.vue_element_admin.VO.UserListQueryVO;
import com.pangzi.vue_element_admin.entity.ResponseStatus;
import com.pangzi.vue_element_admin.entity.User;
import com.pangzi.vue_element_admin.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/{id}/state/{state}")
    public ResultData changeUserState(@PathVariable("id") Integer id, @PathVariable("state") Boolean state){
        ResultData resultData =new ResultData();
        try {
            userService.changeUserState(id,state);
            resultData.setCode(ResponseStatus.OK.getCode());
            resultData.setMessage("修改成功");
        } catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("修改用户状态失败");
        }
        return resultData;
    }

    @PostMapping(value = "users")
    public ResultData addUser(@RequestBody UserVO user){
        ResultData resultData = new ResultData();
        try{
            userService.addUser(user);
            resultData.setCode(ResponseStatus.OK.getCode());
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("添加用户失败");
        }
        return resultData;
    }

    @GetMapping(value = "users/{id}")
    public ResultData getUserById(@PathVariable("id") Integer id){
        ResultData resultData = new ResultData();
        try{
            resultData.setData(userService.getUserById(id));
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("获取用户信息失败");
        }
        return resultData;
    }

    @PutMapping(value = "users/{id}")
    public  ResultData modifyUserInfo(@PathVariable("id") Integer id, @RequestBody User user){
        ResultData resultData = new ResultData();
        try{
           userService.updateUserInfoById(id,user.getEmail(),user.getMobile());
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("更新用户信息失败");
        }
        return resultData;
    }

    @DeleteMapping(value = "users/{id}")
    public ResultData deleteUserById(@PathVariable("id") Integer id){
        ResultData resultData = new ResultData();
        try {
            userService.deleteUserById(id);
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("删除用户失败");
        }
        return resultData;
    }

    @PutMapping(value = "{id}/role")
    public ResultData editRoleOfUser(@PathVariable("id") Integer id, @RequestBody RoleVo roleVo){
        ResultData resultData = new ResultData();
        try {
            userService.editRoleOfUser(id,roleVo);
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("删除用户失败");
        }
        return resultData;
    }
}
