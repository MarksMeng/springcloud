package com.pangzi.vue_element_admin.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Goods {
    private Integer goodsId;
    private String goodsName;
    private long goodsPrice;
    private Integer goodsNumber;
    private Integer goodsWeight;
    private Integer cateId;//三级分类ID
    private String goodsCate;
    private String goodsIntroduce;
    private String pics;
    private Integer isDel=0; //0:正常  1:删除
    private Date addTime=new Date();
    private Date updTime=new Date();//修改商品时间
    private Date deleteTime;//软删除标志字段
    private Integer catOneId;//一级分类id
    private Integer catTwoId;//二级分类id
    private Integer catThreeId;//三级分类id
    private Integer hotNumber;//热卖数量
    private Integer isPromote=0;//是否促销 0:否 1：是
    private Integer goodsState=0;//商品状态 0: 未通过 1: 审核中 2: 已审核
    private List<AttrOfGoods> attrs;
}
