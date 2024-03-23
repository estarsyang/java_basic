package com.itheima.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Aspect
public class LogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Around("@annotation(com.itheima.anno.Log)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

//        operator id
        String jwt = httpServletRequest.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operatorId = (Integer) claims.get("id");

//        operate time
        LocalDateTime operateTime = LocalDateTime.now();

//        classname
        String className = proceedingJoinPoint.getTarget().getClass().getName();

//        method name
        String methodName = proceedingJoinPoint.getSignature().getName();

//        method params
        Object[] args = proceedingJoinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        long begin = System.currentTimeMillis();
//        return value
//        call origin method
        Object result = proceedingJoinPoint.proceed();
        String returnValue = JSONObject.toJSONString(result);

        long end = System.currentTimeMillis();

//        cost time
        Long costTime = end - begin;


//        record operation log
        OperateLog operateLog = new OperateLog(null,operatorId,operateTime,className,methodName,
                methodParams,returnValue,costTime);
        operateLogMapper.insert(operateLog);

        return result;
    }
}
