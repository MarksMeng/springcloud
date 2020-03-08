package com.pangzi.vue_element_admin.util;

import com.pangzi.vue_element_admin.entity.GoodsCate;

import java.util.ArrayList;
import java.util.List;

public class CateListToTree {

    public static List<GoodsCate> listToTree(List<GoodsCate> goodsCateList){
        List<GoodsCate> goodsCateTree = new ArrayList<GoodsCate>();
        for(GoodsCate goodsCate: goodsCateList){
            if("0".equalsIgnoreCase(goodsCate.getCateId().toString()) || null == goodsCate.getCateId() || 0==goodsCate.getCateId()){
                goodsCateTree.add(findChildren(goodsCate,goodsCateList));
            }
        }
        return goodsCateTree;
    }

    public static GoodsCate findChildren(GoodsCate goodsCate,List<GoodsCate> goodsCateList){
        goodsCate.setChildren(new ArrayList<GoodsCate>());
        for (GoodsCate childrenGoodsCate: goodsCateList){
            if( goodsCate.getCateId() == childrenGoodsCate.getCatePid()){
                if(goodsCate.getChildren() == null){
                    goodsCate.setChildren(new ArrayList<>());
                }
                goodsCate.getChildren().add(findChildren(childrenGoodsCate,goodsCateList));
            }
        }
        return goodsCate;
    }
}
