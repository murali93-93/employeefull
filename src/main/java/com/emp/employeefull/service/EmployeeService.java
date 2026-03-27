package com.emp.employeefull.service;


import com.emp.employeefull.dto.EmployeeDto;
import com.emp.employeefull.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getByEmployeeId(Long employeeId);

    public EmployeeDto createEmployeeRecord(EmployeeDto employee);

    public EmployeeDto updateEmployeeRecord(EmployeeDto employee);

    public List<Employee> getAllEmployees();

    public List<Employee> saveAllEmployeeRecord(List<Employee> employees);
}
