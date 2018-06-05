package com.example.demo.handler;


import com.example.demo.common.result.Result;
import com.example.demo.common.enums.ResultEnum;
import com.example.demo.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = BusinessException.class)
    public Result businessExceptionHandler(BusinessException e) {
        Result result = new Result();
        logger.info("msg = {}", e.getMessage());

        result.setCode(e.getCode());
        result.setMessage(e.getMessage());

        return result;
    }

    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception e) {
        Result result = new Result();
        logger.info("msg = {}", e.getMessage());

        ResultEnum resultEnum = ResultEnum.SYSTEM_ERROR;
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());

        return result;
    }
}
