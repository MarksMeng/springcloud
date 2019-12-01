package com.pangzi.vue_element_admin.VO;

import lombok.Data;

@Data
public class ResultData {
    /**
     * 错误信息
     */
    private String message;

    /**
     * 响应状态码
     */
    private String code;

    /**
     * 响应数据
     */
    private Object data;

    public ResultData() {
        this.code = "OK";
    }
}
