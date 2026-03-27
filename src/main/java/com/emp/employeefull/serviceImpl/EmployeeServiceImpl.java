package com.emp.employeefull.serviceImpl;

import com.emp.employeefull.dto.EmployeeDto;
import com.emp.employeefull.entity.Employee;
import com.emp.employeefull.exceptionn.CustomException;
import com.emp.employeefull.repo.EmployeeRepository;
import com.emp.employeefull.response.EmployeeResponse;
import com.emp.employeefull.response.ErrorResponse;
import com.emp.employeefull.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getByEmployeeId(Long employeeId){
        log.info("Entered Into The Service to getByEmployeeId Method");
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new CustomException("Employee not found",
                        "EMP_NOT_FOUND",
                        "Employee id: " + employeeId + " does not exist",
                        HttpStatus.NOT_FOUND)
        );
        log.info("Scucces Fully fetched the Record of employee");
        log.info("Employe Details"+employee);
        return employee;
    }

    @Override
    public Employee createEmployeeRecord(Employee employee) {
        log.info("Entered Into The Service to createEmployeeRecord Method");
        try {
            Employee employeeDB = employeeRepository.save(employee);
            log.info("Employee created successfully: {}", employeeDB);
            return employeeDB;

        }catch (Exception e) {
            throw new CustomException(
                    "Database error",
                    "DB_ERROR",
                    e.getMessage(),
                    org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

    @Override
    public Employee updateEmployeeRecord(Employee employee) {
        log.info("Entered Into The Service to updateEmployeeRecord Method");
        try {
           /* if(employee.getId()!=null){
                Employee fetchedEmployeeDB=employeeRepository.getById(employee.getId());
                mapToEmployee(fetchedEmployeeDB);
            }else {
                throw new CustomException();
            }*/
            Employee employeeDB = employeeRepository.save(employee);
            log.info("Employee created successfully: {}", employeeDB);
            return employeeDB;

        } catch (Exception e) {
            log.error("Error while saving employee", e);

            throw new CustomException(
                    "Database error",
                    "DB_ERROR",
                    e.getMessage(),
                    org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public List<Employee> getAllEmployees(){
        log.info("Entered Into The Service to getAllEmployees Method");
       return  employeeRepository.findAll();

    }

    @Override
    public List<Employee> saveAllEmployeeRecord(List<Employee> employees) {
        return  employeeRepository.saveAll(employees);
    }
}
