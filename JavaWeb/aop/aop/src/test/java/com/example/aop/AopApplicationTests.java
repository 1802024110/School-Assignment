package com.example.aop;

import com.example.aop.server.EmployeeManager;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootTest
class AopApplicationTests {
    @Resource
    private EmployeeManager employeeManager;
    @Test
    void contextLoads() {
        employeeManager.getEmployeeById(1);
    }
}
