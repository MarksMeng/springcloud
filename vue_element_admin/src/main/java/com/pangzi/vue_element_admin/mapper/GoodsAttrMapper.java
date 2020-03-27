package com.pangzi.vue_element_admin.mapper;

import com.pangzi.vue_element_admin.entity.GoodsAttr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.List;

@Mapper
@Component
public interface GoodsAttrMapper {

    List<GoodsAttr> getAttributesByCateId(@Param("cateId") Integer cateId, @Param("sel") String sel);

    void addAttribute(GoodsAttr goodsAttr);

    void updateAttributesByAttrIdAndCateId(GoodsAttr goodsAttr);

    void deleteAttributesByAttrIdAndCateId(@Param("cateId") Integer cateId,@Param("attrId") Integer attrId);

}
