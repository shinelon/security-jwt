package com.shinelon.securityjwt.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalExceptionConfig
 * @Author shinelon
 * @Date 13:52 2022/9/1
 * @Version 1.0
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionConfig {

    @ExceptionHandler(Throwable.class)
    public String exception(HttpServletRequest request, Exception e) {
        String sign = "?";
        StringBuffer requestUrl = request.getRequestURL();
        String queryString = request.getQueryString();

        if (StringUtils.isNotBlank(queryString)) {
            requestUrl.append(sign);
            requestUrl.append(queryString);
        }
        log.error("error: {}, requestURL: {}", e.getLocalizedMessage(), requestUrl.toString());
        log.error(e.getMessage(), e);
        return e.getLocalizedMessage();
    }
}
