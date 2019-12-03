package com.pangzi.vue_element_admin.VO;

import lombok.Data;

@Data
public class UserListQueryVO {
    private String query; //名字查询
    private Integer pageNum;
    private Integer pageSize;
}
