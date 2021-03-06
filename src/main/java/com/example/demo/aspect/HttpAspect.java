package com.example.demo.aspect;

import com.example.demo.common.result.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.demo.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBeforeController(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("http_url = {}", request.getRequestURI());
        logger.info("http_method = {}", request.getMethod());
        logger.info("http_ip = {}", request.getRemoteAddr());
        logger.info("class_method = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("class_method_args = {}", joinPoint.getArgs());
    }

    @Before("log()")
    public void doAfterController(JoinPoint joinPoint) {
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturningController(Object object) {
        if(object instanceof Result){
            ((Result) object).setMessage("success");
            ((Result) object).setCode(1);
        }
        logger.info("response = {}", object);
    }

}
