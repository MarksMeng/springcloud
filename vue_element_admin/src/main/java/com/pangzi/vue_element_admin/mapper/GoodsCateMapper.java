package com.pangzi.vue_element_admin.mapper;

import com.pangzi.vue_element_admin.VO.CateVO;
import com.pangzi.vue_element_admin.entity.GoodsCate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface GoodsCateMapper {

    List<GoodsCate> getGoodsCateListOfLevel1();

    List<GoodsCate> getGoodsCateListByPid(@Param("catePid")Integer catePid);

    void insertNewCate(CateVO cateVO);

    void updateCateNameByCateId(@Param("cateId") Integer cateId,@Param("cateName") String cateName);

    void deleteGoodsCateByCateIdList(@Param("cateIdList") List<Integer> cateIdList);
}
