package com.emp.employeefull.service;


import com.emp.employeefull.entity.Employee;
import com.emp.employeefull.exceptionn.CustomException;

import java.util.List;

public interface EmployeeService {

    public Employee getByEmployeeId(Long employeeId);

    public Employee createEmployeeRecord(Employee employee);

    public Employee updateEmployeeRecord(Employee employee);

    public List<Employee> getAllEmployees();

    public List<Employee> saveAllEmployeeRecord(List<Employee> employees);
}
