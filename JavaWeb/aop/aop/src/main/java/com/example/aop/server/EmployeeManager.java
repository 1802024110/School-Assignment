package com.example.aop.server;

import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {
    public void getEmployeeById(Integer id){
        System.out.println("getEmployeeById被执行了");
    }
}
