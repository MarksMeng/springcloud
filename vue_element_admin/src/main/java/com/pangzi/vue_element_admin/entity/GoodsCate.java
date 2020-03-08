package com.pangzi.vue_element_admin.entity;

import lombok.Data;

import java.util.List;

@Data
public class GoodsCate {
    private Integer cateId;
    private String cateName;
    private Integer cateLevel;
    private Integer catePid;
    private Boolean cateDelete;
    private List<GoodsCate> children;
}
