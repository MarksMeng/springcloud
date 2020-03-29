package com.pangzi.vue_element_admin.mapper;

import com.pangzi.vue_element_admin.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.List;

@Mapper
@Component
public interface GoodsMapper {

    List<Goods> getGoodsListByPage(String goodsName);

    void deleteGoodsByGoodsId(@Param("goodsId") Integer goodsId);

    void saveGoods(Goods goods);
}
