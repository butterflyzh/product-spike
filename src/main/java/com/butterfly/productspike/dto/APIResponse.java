package com.butterfly.productspike.dto;

import lombok.Data;

@Data
public class APIResponse<T> {

    private Integer code;

    private String msg;

    private T data;

    public APIResponse(T data){
        this.data = data;
    }

    public APIResponse(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public APIResponse ofFail(){
        return new APIResponse<>(100, "fail");
    }
}
