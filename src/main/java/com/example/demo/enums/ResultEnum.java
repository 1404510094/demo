package com.example.demo.enums;

public enum ResultEnum {
    SUCCESS(0,"成功"),
    UNKONW_ERROE(-1, "未知错误"),
    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}