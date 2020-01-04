package com.pangzi.vue_element_admin.entity;

public enum ResponseStatus {
    OK("成功","OK"),
    ERROR("失败","ERROR");


    private String name;

    private String code;

    //构造方法
    ResponseStatus(String name, String code) {
        this.name = name;
        this.code = code;
    }


    //覆盖toString
    @Override
    public String toString(){
        return "状态说明："+this.name+";错误码："+this.code;
    }

    //getCode
    public String getCode(){
        return this.code;
    }

    //getName
    public String getName(){
        return this.name;
    }

}
