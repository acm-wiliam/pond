package com.yws.controller.utils;

import lombok.Data;

@Data
public class R {
    private boolean flag;
    private Object data;

    public R(boolean flag){
        this.flag=flag;
    }
    public R(boolean flag,Object obj){
        this.flag=flag;
        data=obj;
    }
    public R(){}
}
