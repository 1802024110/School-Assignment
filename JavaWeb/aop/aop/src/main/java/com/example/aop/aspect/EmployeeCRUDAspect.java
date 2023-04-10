package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
// 员工增删改查的 切面
public class EmployeeCRUDAspect  {
    @Before("execution(* *.getEmployeeById(..))")
    public void logBeforeV1(JoinPoint joinPoint){
        System.out.println("EmployeeCRUDAspect.logBeforeV1():" + joinPoint.getSignature().getName());
    }
}
