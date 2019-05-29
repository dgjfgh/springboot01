package com.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Created by majianghua on 2019/5/28.
 */
@Aspect
@Component
public class MyAop {
    @Pointcut("execution(public * com.demo.controller.*.get*(..))")
    public void pointCut(){}

    @Before("com.demo.aop.MyAop.pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();//方法参数
        System.out.println(joinPoint.getSignature().getName()+"除法运行");
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("除法结束");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("除法返回"+result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void logException(Exception e) {
        System.out.println("除法异常"+e.getMessage());
    }
}