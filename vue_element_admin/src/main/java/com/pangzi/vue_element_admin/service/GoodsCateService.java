package com.pangzi.vue_element_admin.service;

import com.github.pagehelper.PageInfo;
import com.pangzi.vue_element_admin.VO.CateListVo;
import com.pangzi.vue_element_admin.VO.CateVO;
import com.pangzi.vue_element_admin.entity.GoodsCate;

import java.util.List;

public interface GoodsCateService {

    PageInfo<GoodsCate> getGoodsCateList(CateListVo cateListVo) throws Exception;

    /**
     * 获取一级和二级分类并以树的形式返回
     * @return
     */
    List<GoodsCate> getParentCateList(Integer cateLevel) throws Exception;

    void addCate(CateVO cateVO) throws Exception;

    void updateCateNameByCateId(Integer cateId,String cateName) throws Exception;

    void deleteCateByCateId(Integer cateId) throws Exception;
}
