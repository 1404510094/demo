package com.example.demo.handler;


import com.example.demo.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class MyExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(HttpServletRequest request, Exception e) {
        logger.info("TEST");
        Result result = new Result();
        result.setCode(-1);
        result.setData(null);
        return result;
    }
}
