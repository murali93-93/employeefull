package com.emp.employeefull.serviceImpl;


import com.emp.employeefull.dto.AddressDto;
import com.emp.employeefull.dto.AddressDtoRequest;
import com.emp.employeefull.dto.EmployeeDto;
import com.emp.employeefull.entity.Employee;
import com.emp.employeefull.exceptionn.CustomException;
import com.emp.employeefull.feignClient.AddressClient;
import com.emp.employeefull.repo.EmployeeRepository;

import com.emp.employeefull.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }
     @Autowired
     private AddressClient addressClient;

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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public EmployeeDto createEmployeeRecord(EmployeeDto employee) {
        log.info("Entered Into The Service to createEmployeeRecord Method");
        try {
            Employee employeeEntity = new Employee();
            employeeEntity.setFullName(employee.getFullName());
            employeeEntity.setLastName(employee.getLastName());
            employeeEntity.setEmail(employee.getEmail());
            employeeEntity.setPhoneNumber(String.valueOf(employee.getPhoneNumber()));
            employeeEntity.setBloodGroup(employee.getBloodGroup());
            employeeEntity.setSalary(employee.getSalary());
        
            Employee employeeDB = employeeRepository.save(employeeEntity);
            log.info("Employee created successfully: {}", employeeDB);
            
             List<AddressDtoRequest> validAddresses = employee.getAddresss().stream().filter(Objects::nonNull).toList();
               
             List<AddressDto> addressDtoListt=new ArrayList<>();

            for (AddressDtoRequest address : validAddresses) {

                AddressDto addressDto = new AddressDto();
                addressDto.setStreet(address.getStreet());
                addressDto.setCity(address.getCity());
                addressDto.setState(address.getState());
                addressDto.setCountry(address.getCountry());
                addressDto.setPincodeString(address.getPincodeString());
                addressDto.setAddressType(address.getAddressType());
                addressDto.setEmployeeId(employeeDB.getId());

                addressDtoListt.add(addressDto);
            
            }
            addressClient.SaveAddress(addressDtoListt);
            return getEmployeeDto(employeeDB);
            
        }catch (Exception e) {
            throw new CustomException(
                    "Database error",
                    "DB_ERROR",
                    e.getMessage(),
                    org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }
 private EmployeeDto getEmployeeDto(Employee employeeDB) {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employeeDB.getId());
        employeeDto.setFullName(employeeDB.getFullName());
        employeeDto.setLastName(employeeDB.getLastName());
        employeeDto.setEmail(employeeDB.getEmail());
        employeeDto.setPhoneNumber(employeeDB.getPhoneNumber());
        employeeDto.setBloodGroup(employeeDB.getBloodGroup());
        employeeDto.setSalary(employeeDB.getSalary());
        return employeeDto;
    }

 @Transactional(propagation = Propagation.REQUIRED, rollbackFor = CustomException.class)
    @Override
    public EmployeeDto updateEmployeeRecord(EmployeeDto employee) {
        log.info("Entered Into The Service to updateEmployeeRecord Method");
        try {
           Employee employeeEntity = new Employee();
            employeeEntity.setFullName(employee.getFullName());
            employeeEntity.setLastName(employee.getLastName());
            employeeEntity.setEmail(employee.getEmail());
            employeeEntity.setPhoneNumber(String.valueOf(employee.getPhoneNumber()));
            employeeEntity.setBloodGroup(employee.getBloodGroup());
            employeeEntity.setSalary(employee.getSalary());
            
            Employee employeeDB = employeeRepository.save(employeeEntity);
            log.info("Employee created successfully: {}", employeeDB);

            return getEmployeeDto(employeeDB);

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
