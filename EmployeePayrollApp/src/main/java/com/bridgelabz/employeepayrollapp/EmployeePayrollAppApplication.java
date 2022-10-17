package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployeePayrollAppApplication.class, args);
        log.info("Application Started");
        log.info("Employee Payroll App has Started in {} Environment",context.getEnvironment().getProperty("environment"));
        log.info("Database : User Name is {}",context.getEnvironment().getProperty("spring.datasource.username"));
    }

}