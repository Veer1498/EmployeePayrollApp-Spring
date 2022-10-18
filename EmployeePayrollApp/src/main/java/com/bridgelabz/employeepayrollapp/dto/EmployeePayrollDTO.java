package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Data
public class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    @NotEmpty(message = "Employee Name should not be Null")
    private String name;

    @Min(value = 500,message = "Minimum Wage should be 500 or More")
    private long salary;

    @Pattern(regexp = "male|female|others",message = "Gender Needs to be Male,Female or Others")
    private String gender;

    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "startDate Should not be Empty")
    @PastOrPresent(message = "startDate Should not be past or present Date")
    private Date startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "Profile Pic should not be Empty")
    private String profilePic;

    @NotNull(message = "department should not be Empty")
    private List<String> department;


}
