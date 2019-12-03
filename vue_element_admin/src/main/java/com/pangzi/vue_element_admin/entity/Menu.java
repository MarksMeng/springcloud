package com.pangzi.vue_element_admin.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private Integer id;
    private String authName;
    private String urlPath;
    private Integer parentId;
    private String logo;
    private List<Menu> children;
}
