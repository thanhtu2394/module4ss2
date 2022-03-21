package com.example.aspect_quan_ly_khach_hang.logger;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class log {
    @Before("execution(public * com.example.aspect_quan_ly_khach_hang.controler.CustomerController.*(..))")
    public void log(JoinPoint joinPoint){
        System.out.println("kkkkk");
        String method=joinPoint.getSignature().getName();
    }
    @After("execution(public * com.example.aspect_quan_ly_khach_hang.controler.CustomerController.*(..))")
    public void log1(JoinPoint joinPoint){
        String clas =joinPoint.getTarget().getClass().getSimpleName();
        String method=joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("hello :" + method +","+clas);
    }
    @AfterThrowing(value = "execution(public * com.example.aspect_quan_ly_khach_hang.controler.CustomerController.*(..))",throwing ="e")
    public void log1(JoinPoint joinPoint,Exception e) {
        String clas =joinPoint.getTarget().getClass().getSimpleName();
        String method=joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("hello :" + method +","+clas+","+e.getMessage()+args);
    }
}
