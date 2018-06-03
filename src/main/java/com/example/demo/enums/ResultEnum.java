package com.example.demo.enums;

public enum ResultEnum {
    SUCCESS(1,"成功"),
    UNKONW_ERROE(-1, "未知错误"),
    SYSTEM_ERROR(-1000,"系统错误"),
    NO_RESULT(-100,"未获取到结果"),
    UPDATE_ERROR(-101,"更新失败"),
    DELETE_ERROR(-102,"删除失败"),
    INSERT_ERROR(-103,"插入失败"),
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