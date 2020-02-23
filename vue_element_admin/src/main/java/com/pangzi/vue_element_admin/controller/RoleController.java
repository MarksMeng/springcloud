package com.pangzi.vue_element_admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.pangzi.vue_element_admin.VO.ResultData;
import com.pangzi.vue_element_admin.entity.ResponseStatus;
import com.pangzi.vue_element_admin.entity.Role;
import com.pangzi.vue_element_admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(value = "role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "roles")
    public ResultData getRolesList(){
        ResultData resultData = new ResultData();
        try{
            resultData.setData(roleService.getRoleList());
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("获取角色列表失败");
        }
        return resultData;
    }

    @PostMapping(value = "role")
    public ResultData addRole(@RequestBody Role role){
        ResultData resultData = new ResultData();
        try{
            roleService.insertOneRole(role);
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("添加角色失败");
        }
        return resultData;
    }

    @GetMapping(value = "role/{id}")
    public ResultData getRoleInfoById(@PathVariable("id") Integer id){
        ResultData resultData = new ResultData();
        try{
            resultData.setData(roleService.findRoleInfoById(id));
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("获取角色信息失败");
        }
        return resultData;
    }

    @PutMapping(value = "role/{id}")
    public ResultData updateRoleInfoById(@PathVariable("id") Integer id,@RequestBody Role role){
        ResultData resultData = new ResultData();
        try{
            roleService.updateRoleInfoById(id,role);
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("更新角色信息错误");
        }
        return resultData;
    }

    @DeleteMapping(value = "role/{id}")
    public ResultData deleteRoleInfoById(@PathVariable("id")Integer id){
        ResultData resultData = new ResultData();
        try{
            roleService.deleteRoleInfoById(id);
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("删除角色信息失败");
        }
        return resultData;
    }

    @DeleteMapping(value = "role/{rid}/auth/{aid}")
    public ResultData deleteAuthOfRoleByAuthIdAndRoleId(@PathVariable("rid")Integer rid,@PathVariable("aid")Integer aid){
        ResultData resultData = new ResultData();
        try{
            roleService.deleteAuthOfRoleByAuthIdAndRoleId(rid,aid);
            resultData.setData(roleService.findRoleInfoById(rid));
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("删除角色信息失败");
        }
        return resultData;
    }

    @PostMapping(value = "role/{rid}/auth")
    public ResultData addAuthToRoleByRoleId(@PathVariable("rid")Integer rid, @RequestBody String aidList){
        ResultData resultData = new ResultData();
        try{
            String aidStr = JSONObject.parseObject(aidList).getString("aidList");
            roleService.addAuthToRoleByRoleId(rid,aidStr);
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage("角色分配权限失败");
        }
        return resultData;
    }
}
