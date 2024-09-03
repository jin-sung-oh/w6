package org.zerock.w6.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class LogAdvice {

    @Before("execution(* org.zerock.w6.service.*.*(..))")
    public void Before(JoinPoint joinPoint) {
        log.info("------------------------------");
        log.info("------------------------------");
        log.info("------------------------------");
        log.info("------------------------------");
    }

    @Around("execution(* org.zerock.w6.service.*.*(..))")
    public Object logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
     Long start = System.currentTimeMillis();

     Object result = joinPoint.proceed();

     Long end = System.currentTimeMillis();

     log.info("TIME: " + (end - start));


     return result;
    }
}
