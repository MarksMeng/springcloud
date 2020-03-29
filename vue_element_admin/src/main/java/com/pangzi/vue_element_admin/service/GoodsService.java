package com.pangzi.vue_element_admin.service;

import com.github.pagehelper.PageInfo;
import com.pangzi.vue_element_admin.VO.GoodsQueryVO;
import com.pangzi.vue_element_admin.entity.Goods;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface GoodsService {
    PageInfo<Goods> getGoodsListByPage(GoodsQueryVO goodsQueryVO) throws Exception;

    void deleteGoodsByGoodsId(Integer goodsId) throws Exception;

    String uploadImage(MultipartFile file) throws Exception;

    void deleteImg(String filePath) throws Exception;

    void saveGoods(Goods goods) throws Exception;
}
