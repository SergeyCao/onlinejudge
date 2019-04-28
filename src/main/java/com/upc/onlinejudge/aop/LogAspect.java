package com.upc.onlinejudge.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * com.upc.onlinejudge.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void logBefore(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        StringBuilder log = new StringBuilder("URL: " + httpServletRequest.getRequestURL() +
                " HttpMethod: " + httpServletRequest.getMethod() +
                " IP: " + httpServletRequest.getRemoteAddr() + " QueryString: " + httpServletRequest.getQueryString());
        Enumeration<String> enu = httpServletRequest.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = enu.nextElement();
            log.append(String.format("name:%s,value:%s", name, httpServletRequest.getParameter(name)));
        }
        logger.info(log.toString());
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        logger.info("RESPONSE : " + ret.toString());
    }
}
