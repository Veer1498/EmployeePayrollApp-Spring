package com.bridgelabz.employeepayrollapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

public class EmployeeData {
    private long empID;
    private String empName;
    private long empSalary;

    public EmployeeData(int empID, String empName, long empSalary) {
        this.empID = empID;
        this.empName = empName;
        this.empSalary = empSalary;
    }

    public EmployeeData() {

    }

    public int getEmpID() {
        return (int) empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public long getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(long empSalary) {
        this.empSalary = empSalary;
    }
}
