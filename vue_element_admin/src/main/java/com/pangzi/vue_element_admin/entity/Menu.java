package com.pangzi.vue_element_admin.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private int id;
    private String authName;
    private String urlPath;
    private int parentId;
    private List<Menu> children;
}
