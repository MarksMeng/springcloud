package com.pangzi.vue_element_admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pangzi.vue_element_admin.VO.CateListVo;
import com.pangzi.vue_element_admin.VO.CateVO;
import com.pangzi.vue_element_admin.entity.GoodsCate;
import com.pangzi.vue_element_admin.mapper.GoodsCateMapper;
import com.pangzi.vue_element_admin.service.GoodsCateService;
import com.pangzi.vue_element_admin.util.CateListToTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsCateServiceImpl implements GoodsCateService {

    @Autowired
    private GoodsCateMapper goodsCateMapper;

    @Override
    public PageInfo<GoodsCate> getGoodsCateList(CateListVo cateListVo) throws Exception{
        PageHelper.startPage(cateListVo.getPageNum(),cateListVo.getPageSize());
        List<GoodsCate> goodsCateList = goodsCateMapper.getGoodsCateListOfLevel1();
        for(GoodsCate goodsCate:goodsCateList){
            List<GoodsCate> goodsCateListSec = goodsCateMapper.getGoodsCateListByPid(goodsCate.getCateId());
            for (GoodsCate goodsCateChildren: goodsCateListSec){
                List<GoodsCate> goodsCateListThr = goodsCateMapper.getGoodsCateListByPid(goodsCateChildren.getCateId());
                goodsCateChildren.setChildren(goodsCateListThr);
            }
            goodsCate.setChildren(goodsCateListSec);
        }
        return new PageInfo<>(goodsCateList);
    }

    @Override
    public List<GoodsCate> getParentCateList() throws Exception{
        List<GoodsCate> goodsCateList = goodsCateMapper.getGoodsCateListOfLevel1();
        for(GoodsCate goodsCate:goodsCateList){
            List<GoodsCate> goodsCateListSec = goodsCateMapper.getGoodsCateListByPid(goodsCate.getCateId());
            goodsCate.setChildren(goodsCateListSec);
        }
        return goodsCateList;
    }

    @Override
    public void addCate(CateVO cateVO) throws Exception{
        goodsCateMapper.insertNewCate(cateVO);
    }

    @Override
    public void updateCateNameByCateId(Integer cateId,String cateName) throws Exception{
        goodsCateMapper.updateCateNameByCateId(cateId,cateName);
    }

    @Override
    public void deleteCateByCateId(Integer cateId) throws Exception{
        List<Integer> cateIdList = new ArrayList<>();
        cateIdList.add(cateId);
        List<GoodsCate> goodsCateList = goodsCateMapper.getGoodsCateListByPid(cateId);
        for(GoodsCate goodsCate:goodsCateList){
            cateIdList.add(goodsCate.getCateId());
            if(goodsCate.getCateLevel()!=3){
                List<GoodsCate> goodsCateList1 = goodsCateMapper.getGoodsCateListByPid(goodsCate.getCateId());
                for(GoodsCate goodsCate2:goodsCateList1){
                    cateIdList.add(goodsCate2.getCateId());
                }
            }
        }
        if(cateIdList!=null && !cateIdList.isEmpty() ){
            goodsCateMapper.deleteGoodsCateByCateIdList(cateIdList);
        }else{
            throw new RuntimeException("cateId 为空");
        }
    }
}
