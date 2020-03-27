package com.pangzi.vue_element_admin.controller;

import com.pangzi.vue_element_admin.VO.CateListVo;
import com.pangzi.vue_element_admin.VO.CateVO;
import com.pangzi.vue_element_admin.VO.ResultData;
import com.pangzi.vue_element_admin.entity.GoodsAttr;
import com.pangzi.vue_element_admin.entity.ResponseStatus;
import com.pangzi.vue_element_admin.service.GoodsAttrService;
import com.pangzi.vue_element_admin.service.GoodsCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsCateService goodsCateService;

    @Autowired
    private GoodsAttrService goodsAttrService;

    @GetMapping("/categories")
    public ResultData getCateList(CateListVo cateListVo){
        ResultData resultData = new ResultData();
        try{
            resultData.setData(goodsCateService.getGoodsCateList(cateListVo));
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage(e.getMessage());
        }
        return resultData;
    }

    @GetMapping("/parentCateList/{cateLevel}")
    public ResultData getParentCateList(@PathVariable("cateLevel") Integer cateLevel){
        ResultData resultData = new ResultData();
        try {
            resultData.setData(goodsCateService.getParentCateList(cateLevel));
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage(e.getMessage());
        }
        return resultData;
    }

    @PostMapping("/addCate")
    public ResultData addCate(@RequestBody CateVO cateVO){
        ResultData resultData = new ResultData();
        try {
            goodsCateService.addCate(cateVO);
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage(e.getMessage());
        }
        return resultData;
    }

    @PutMapping("/updateCate/{cateId}/{cateName}")
    public ResultData updateCateNameByCateId(@PathVariable("cateId")Integer cateId,@PathVariable("cateName")String cateName){
        ResultData resultData = new ResultData();
        try {
            goodsCateService.updateCateNameByCateId(cateId,cateName);
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage(e.getMessage());
        }
        return resultData;
    }

    @DeleteMapping("/deleteCate/{cateId}")
    public ResultData deleteCateByCateId(@PathVariable("cateId")Integer cateId){
        ResultData resultData = new ResultData();
        try {
            goodsCateService.deleteCateByCateId(cateId);
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage(e.getMessage());
        }
        return resultData;
    }

    @GetMapping("/{cateId}/attributes")
    public ResultData getParamList(@PathVariable("cateId")Integer cateId,@RequestParam("sel")String sel){
        ResultData resultData = new ResultData();
        try {
            resultData.setData(goodsAttrService.getAttributesByCateId(cateId, sel));
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage(e.getMessage());
        }
        return resultData;
    }

    @PostMapping("categories/{cateId}/attributes")
    public ResultData getParamList(@PathVariable("cateId")Integer cateId, @RequestBody GoodsAttr goodsAttr){
        ResultData resultData = new ResultData();
        try {
            goodsAttr.setCateId(cateId);
            goodsAttrService.addAttribute(goodsAttr);
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage(e.getMessage());
        }
        return resultData;
    }

    @PutMapping("categories/{cateId}/attributes/{attrId}")
    public ResultData updateAttributesByAttrIdAndCateId(@PathVariable("cateId")Integer cateId,@PathVariable("attrId")Integer attrId, @RequestBody GoodsAttr goodsAttr){
        ResultData resultData = new ResultData();
        try {
            goodsAttrService.updateAttributesByAttrIdAndCateId(cateId,attrId,goodsAttr)
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage(e.getMessage());
        }
        return resultData;
    }

    @DeleteMapping("categories/{cateId}/attributes/{attrId}")
    public ResultData deleteAttributesByAttrIdAndCateId(@PathVariable("cateId")Integer cateId,@PathVariable("attrId")Integer attrId){
        ResultData resultData = new ResultData();
        try {
            goodsAttrService.deleteAttributesByAttrIdAndCateId(cateId,attrId);
        }catch (Exception e){
            e.printStackTrace();
            resultData.setCode(ResponseStatus.ERROR.getCode());
            resultData.setMessage(e.getMessage());
        }
        return resultData;
    }
}
