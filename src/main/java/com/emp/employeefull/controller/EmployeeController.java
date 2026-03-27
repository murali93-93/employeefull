package com.emp.employeefull.controller;

import com.emp.employeefull.entity.Employee;
import com.emp.employeefull.exceptionn.CustomException;
import com.emp.employeefull.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
@Tag(name = "Employee API", description = "Operations related to employees")
public class EmployeeController {

    //private static final Logger logg= LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    EmployeeService employeeService;

    @Operation(summary = "Get EemployeeByID")
    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@Parameter(description = "Employee ID", example = "101")
                                                        @PathVariable(name = "id") Long employeeId) throws CustomException {
        log.info("Entered Into The Controller GetEmployee Method");
        Employee employeeResponse = employeeService.getByEmployeeId(employeeId);
        log.info("get GetEmployee  in Controller: Success");
        return ResponseEntity.ok(employeeResponse);
    }

    @Operation(summary = "save employee")
    @PostMapping("/saveEmployee")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) throws CustomException {
        log.info("Entered Into The Controller saveEmployee Method");
        Employee employeeDb = employeeService.createEmployeeRecord(employee);
        log.info("saveEmployee  in Controller: Success");
        return new ResponseEntity<>(employeeDb, HttpStatus.CREATED);
    }
    @Operation(summary = "updateEmployee")
    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws CustomException {
        log.info("Entered Into The Controller updateEmployee Method");
        Employee updateemployee = employeeService.updateEmployeeRecord(employee);
        log.info("updateEmployees  in Controller: Success");
        return new ResponseEntity<>(updateemployee, HttpStatus.CREATED);
    }
    @Operation(summary = "getAllEmployees")
    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() throws CustomException {
        log.info("Entered Into The Controller getAllEmployees Method");
        List<Employee> employeeDtos=employeeService.getAllEmployees();
        log.info("GetALlEmployess in Controller: Success");
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }
    @Operation(summary = "saveAllEmployee")
    @PostMapping("/saveAllEmployee")
    public ResponseEntity<List<Employee>> saveEmployee(@RequestBody List<Employee> employees) throws CustomException {
        log.info("Entered Into The Controller saveEmployee Method");
        List<Employee> employeeDbList = employeeService.saveAllEmployeeRecord(employees);
        log.info("saveEmployee  in Controller: Success");
        return new ResponseEntity<>(employeeDbList, HttpStatus.CREATED);
    }
}
