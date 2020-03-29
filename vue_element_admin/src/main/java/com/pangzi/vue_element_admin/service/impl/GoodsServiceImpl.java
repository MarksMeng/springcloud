package com.pangzi.vue_element_admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pangzi.vue_element_admin.VO.GoodsQueryVO;
import com.pangzi.vue_element_admin.entity.Goods;
import com.pangzi.vue_element_admin.mapper.AttrWithGoods;
import com.pangzi.vue_element_admin.mapper.GoodsMapper;
import com.pangzi.vue_element_admin.service.GoodsService;
import com.pangzi.vue_element_admin.util.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private AttrWithGoods attrWithGoods;

    @Value("${img.upload.folder}")
    private String imgUploadFolder;

    @Override
    public PageInfo<Goods> getGoodsListByPage(GoodsQueryVO goodsQueryVO) throws Exception {
        PageHelper.startPage(goodsQueryVO.getPageNum(), goodsQueryVO.getPageSize());
        List<Goods> goodsList = goodsMapper.getGoodsListByPage(goodsQueryVO.getGoodsName());
        return new PageInfo<>(goodsList);
    }

    @Override
    @Transactional
    public void deleteGoodsByGoodsId(Integer goodsId) throws Exception {
        goodsMapper.deleteGoodsByGoodsId(goodsId);
        attrWithGoods.deleteByGoodsId(goodsId);
    }

    @Override
    public String uploadImage(MultipartFile file) throws Exception {
        String format = new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
        String realPath = imgUploadFolder + format;
        String fileName = ImgUtil.saveImg(file, realPath);
        String url = "img" + format + "/" + fileName;
        return url;
    }

    @Override
    public void deleteImg(String filePath) throws Exception {
        ImgUtil.deleteImg(filePath);
    }

    @Override
    @Transactional
    public void saveGoods(Goods goods) throws Exception{
        String[] cateList= goods.getGoodsCate().split(",");
        if(cateList.length<3){
            throw new RuntimeException("分类参数错误，请选择三级分类");
        }else{
            goods.setCateId(Integer.parseInt(cateList[2]));
            goods.setCatOneId(Integer.parseInt(cateList[0]));
            goods.setCatTwoId(Integer.parseInt(cateList[1]));
            goods.setCatThreeId(Integer.parseInt(cateList[2]));
        }
        //保存goods,得到goods_id
        goodsMapper.saveGoods(goods);
        //保存goods 和attr关系
        goods.getAttrs().forEach(attr->{
            attr.setGoodsId(goods.getGoodsId());
        });
        attrWithGoods.save(goods.getAttrs());
    }
}
