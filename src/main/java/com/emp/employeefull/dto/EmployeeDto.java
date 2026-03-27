package com.emp.employeefull.dto;

import java.util.List;

public record EmployeeDto(Long id,String name,String email,Long phoneNumber
                         ,String bloodGroup,List<String> address,double salary,String projectId) {

    /*private Long id;
    private String name;
    private String email;
    private Long phoneNumber;
    private String bloodGroup;
    private List<String> address;
    private double salary;
    private String projectId;  // O*/
}
