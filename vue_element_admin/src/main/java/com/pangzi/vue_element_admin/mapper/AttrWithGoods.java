package com.pangzi.vue_element_admin.mapper;

import com.pangzi.vue_element_admin.entity.AttrOfGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AttrWithGoods {
    void save(@Param("attrOfGoods") List<AttrOfGoods> attrOfGoods);

    void deleteByGoodsId(@Param("goodsId")Integer goodsId);
}
