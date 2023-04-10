package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
// 员工增删改查的 切面
public class EmployeeCRUDAspect  {
    @Before("execution(* com.example.aop.server.EmployeeManager.getEmployeeById(..))")
    public void logBeforeV1(JoinPoint joinPoint){
        System.out.println("EmployeeCRUDAspect.logBeforeV1():" + joinPoint.getSignature().getName());
    }
}
