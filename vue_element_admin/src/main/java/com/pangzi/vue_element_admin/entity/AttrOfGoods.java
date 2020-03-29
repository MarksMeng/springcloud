package com.pangzi.vue_element_admin.entity;

import lombok.Data;

@Data
public class AttrOfGoods {
    private Integer id;
    private Integer goodsId;
    private Integer attrId;
    private String attrVals;
}
