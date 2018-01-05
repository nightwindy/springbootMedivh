package com.windy.medivh.core.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DubboLogAspectHandler {

    @Pointcut(value = "execution(public * com.windy.medivh.core.service.dubbo.*.*(..))")
    public void recordLog() {
    }

    /**
     * 同时在所拦截方法的前后执行
     * 在ProceedingJoinPoint.proceed()前后加逻辑
     */
    @Around("recordLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();

        log.info("{}.{} start !,req = {}",joinPoint.getSignature().getDeclaringType() , methodName, JSON.toJSONString(joinPoint.getArgs()));
        Object res = joinPoint.proceed();
//        //记录执行请求耗时
//        log.info("{}.{} finished !,res ={} ",joinPoint.getSignature().getDeclaringType() , methodName, JSON.toJSONString(res));
        return res;
    }

}  