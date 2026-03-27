package com.emp.employeefull.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto{

    private Long id;

    private String fullName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String bloodGroup;

    private double salary;

    private List<AddressDtoRequest> addresss;
}
   

