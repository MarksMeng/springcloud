package com.pangzi.vue_element_admin.VO;

import lombok.Data;

@Data
public class GoodsQueryVO {
    private Integer pageNum;
    private Integer pageSize;
    private String goodsName;
}
