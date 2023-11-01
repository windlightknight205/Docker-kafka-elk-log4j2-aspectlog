package com.example.kreadwritemsg.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut(value = "execution(* com.example.kreadwritemsg.controller.*.*(..))")
    public void loggingPointCut() {
    }
    @Around("loggingPointCut()")
    public Object loggingAdvice(ProceedingJoinPoint pj) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pj.getSignature().getName();
        String className = pj.getTarget().getClass().toString();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        jakarta.servlet.http.HttpServletRequest request = attributes.getRequest();

        // Lấy thông tin về tham số và tiêu đề
        Map<String, String[]> parameterMap = request.getParameterMap();
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, String> headers = new HashMap<>();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headers.put(headerName, headerValue);
        }

        log.info("Method: " + methodName);
        log.info("Class: " + className);
        log.info("Request Parameters: " + mapper.writeValueAsString(parameterMap));
        log.info("Request Headers: " + mapper.writeValueAsString(headers));

        Object[] array = pj.getArgs();
        log.info("Request Body: " + mapper.writeValueAsString(array));

        Object response = pj.proceed();

        log.info("Response: " + mapper.writeValueAsString(response));
        return response;
    }
}

