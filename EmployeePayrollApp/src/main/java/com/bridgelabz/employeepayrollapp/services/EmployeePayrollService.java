package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Puprose : To Create Employee Payroll App and Perform Operations.
 * Author : Veer.Singa
 */
@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    /**
     *
     * @return employee List
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return employeePayrollRepository.findAll();
    }

    /**
     *
     * @param empId
     * @return
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {

        return employeePayrollRepository
                .findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee with "+empId+"does not exists"));

    }

    /**
     *
     * @param empPayrollDTO
     * @return
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData( empPayrollDTO);
//        log.debug("Emp Data : "employeePayrollData.toString());
        return employeePayrollRepository.save(employeePayrollData);
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
        empData.updateEmployeeEmployeePayrollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
    }

    /**
     *
     * @param empId
     */
    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(empData);
    }

    @Override
    public List<EmployeePayrollData> getEmployeePayrollDataByDepartment(String department){
           return employeePayrollRepository.findEmployeesByDepartment(department);
    }
}
