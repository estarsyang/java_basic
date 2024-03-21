package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TimeAspect {

    @Around("execution(* com.itheima.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

//        1. start time
        long begin = System.currentTimeMillis();

//        2. call original method
        Object result = proceedingJoinPoint.proceed();

//        3. record end time, calculate time
        long end = System.currentTimeMillis();

        log.info(proceedingJoinPoint.getSignature() + " method cost time: {}ms",end-begin);


        return result;
    }
}
