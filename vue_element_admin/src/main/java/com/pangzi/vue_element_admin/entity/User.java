package com.pangzi.vue_element_admin.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private int id;

    private String userName;

    private String password;

    private String token;

    private String email;

    private String mobile;

    private String roleName;

    private Boolean state;
}
