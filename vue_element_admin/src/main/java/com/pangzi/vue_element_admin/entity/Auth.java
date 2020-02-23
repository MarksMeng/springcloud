package com.pangzi.vue_element_admin.entity;

import lombok.Data;

import java.util.List;

@Data
public class Auth {

    Integer id;

    Integer pid;

    String authName;

    Integer level;

    String path;

    List<Auth> children;
}
