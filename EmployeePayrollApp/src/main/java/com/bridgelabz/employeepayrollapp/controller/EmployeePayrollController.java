package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeData;
import org.springframework.web.bind.annotation.*;


/**
 * Puprose : To Create Employee Payroll App and Perform Operations.
 * Author : Veer.Singa
 */
@RestController
@RequestMapping("/home")
public class EmployeePayrollController {

    /**
     *
     * @param empDTO
     * @return - empData
     */
    @PostMapping("/insertData")
    public EmployeeData insertData(@RequestBody EmployeePayrollDTO empDTO){
        EmployeeData empData = new EmployeeData(1,empDTO.empName,empDTO.empSalary);
        return empData;
    }

    /**
     *
     * @param id
     * @return Employee Object
     */
    @GetMapping("/GetByID/{id}")
    public EmployeeData getEmployeeByID(@PathVariable long id){
        long idn = 2;
        EmployeeData empData = new EmployeeData((int) idn,"Veer",35000);
        if (idn == id){
            return empData;
        }
        return null;
    }
}
