package com.pangzi.vue_element_admin.service.impl;

import com.pangzi.vue_element_admin.entity.GoodsAttr;
import com.pangzi.vue_element_admin.mapper.GoodsAttrMapper;
import com.pangzi.vue_element_admin.service.GoodsAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsAttrServiceImpl implements GoodsAttrService {

    @Autowired
    private GoodsAttrMapper goodsAttrMapper;

    @Override
    public List<GoodsAttr> getAttributesByCateId(Integer cateId, String sel) {
        return goodsAttrMapper.getAttributesByCateId(cateId, sel);
    }

    @Override
    public void addAttribute(GoodsAttr goodsAttr) {
        goodsAttrMapper.addAttribute(goodsAttr);
    }

    @Override
    public void updateAttributesByAttrIdAndCateId(Integer cateId, Integer attrId, GoodsAttr goodsAttr) {
        goodsAttr.setCateId(cateId);
        goodsAttr.setAttrId(attrId);
        goodsAttrMapper.updateAttributesByAttrIdAndCateId(goodsAttr);
    }

    @Override
    public void deleteAttributesByAttrIdAndCateId(Integer cateId, Integer attrId) {
        goodsAttrMapper.deleteAttributesByAttrIdAndCateId(cateId, attrId);
    }
}
