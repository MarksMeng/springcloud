package com.pangzi.vue_element_admin.service;

import com.pangzi.vue_element_admin.entity.GoodsAttr;

import java.util.List;

public interface GoodsAttrService {
    List<GoodsAttr> getAttributesByCateId(Integer cateId,String sel);

    void addAttribute(GoodsAttr goodsAttr);

    void updateAttributesByAttrIdAndCateId(Integer cateId,Integer attrId, GoodsAttr goodsAttr);

    void deleteAttributesByAttrIdAndCateId(Integer cateId,Integer attrId);
}
