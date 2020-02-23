package com.pangzi.vue_element_admin.entity;

import lombok.Data;

import java.util.List;

@Data
public class Role {

    private Integer id;
    private String roleName;
    private String roleDesc;
    private List<Auth> children;
}
