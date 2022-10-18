package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Puprose : To Create Employee Payroll App and Perform Operations.
 * Author : Veer.Singa
 */
@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    /**
     *
     * @return employee List
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    /**
     *
     * @param empId
     * @return
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {

        return employeePayrollList.stream()
                .filter(empData -> empData.getEmployeeId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));

    }

    /**
     *
     * @param empPayrollDTO
     * @return
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(employeePayrollList.size() + 1, empPayrollDTO);
        employeePayrollList.add(employeePayrollData);
        return employeePayrollData;
    }

    /**
     *
     * @param empId
     * @param empPayrollDTO
     * @return
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.setName(empPayrollDTO.getName());
        empData.setSalary(empPayrollDTO.getSalary());
        employeePayrollList.set(empId - 1, empData);
        return empData;
    }

    /**
     *
     * @param empId
     */
    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId - 1);
    }
}
