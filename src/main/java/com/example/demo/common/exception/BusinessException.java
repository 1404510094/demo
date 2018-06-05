package com.example.demo.common.exception;

import com.example.demo.common.enums.ResultEnum;

/**
 * @author:chengbg
 * @date:2018/6/4
 */
public class BusinessException extends RuntimeException {
    private Integer code;

    private String message;

    public BusinessException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
