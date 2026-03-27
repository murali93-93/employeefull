// package com.emp.employeefull.test.service;

// import com.emp.employeefull.entity.Employee;
// import com.emp.employeefull.repo.EmployeeRepository;
// import com.emp.employeefull.service.EmployeeService;
// import com.emp.employeefull.serviceImpl.EmployeeServiceImpl;
// import lombok.extern.slf4j.Slf4j;
// import org.junit.jupiter.api.Test;
// import static  org.mockito.Mockito.*;
// import  static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.junit.jupiter.MockitoExtension;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// @Slf4j
// @ExtendWith(MockitoExtension.class)
// public class EmployeeServiceTestClass {

//     @Mock
//     private EmployeeRepository employeeRepository;

//     @InjectMocks
//     private EmployeeServiceImpl employeeService;

//     @Test
//     public void saveALlEmployeeSucess(){

//         List<Employee> empList=returnEmployeeDataList();
//         when(employeeRepository.saveAll(any(List.class))).thenReturn(empList);
//         List<Employee> resulttt  =employeeService.saveAllEmployeeRecord(empList);
//            assertNotNull(resulttt);
//         assertEquals(empList.get(0).getLastName(), resulttt.get(0).getLastName());
//         verify(employeeRepository).saveAll(any(List.class));


//     }
//     @Test
//     public void createEmployeeSucess(){

//         Employee employee=returnEmployeeData();
//         when(employeeRepository.save(any())).thenReturn(employee);

//         Employee result = employeeService.createEmployeeRecord(employee);

//         assertNotNull(result);
//         assertEquals("Murali", result.getFullName());
//         verify(employeeRepository).save(any(Employee.class));
//     }

//     private static Employee returnEmployeeData() {

//         Employee employeee=new Employee();
//         employeee.setId(1L);
//         employeee.setFullName("Murali");
//         employeee.setLastName("Mandava");
//         employeee.setEmail("murali.rajyam923@gmail.com");
//         employeee.setBloodGroup("o+");
//         employeee.setPhoneNumber("9878675634");
//         employeee.setSalary(80000);
//         employeee.setAddress(Arrays.asList("Hyderabad","Apoco colony"));
//         return employeee;
//     }

//     private List<Employee> returnEmployeeDataList() {

//         List<Employee> employeeeList=new ArrayList<>();
//         Employee employeee=new Employee();
//         employeee.setId(1L);
//         employeee.setFullName("Murali");
//         employeee.setLastName("Mandava");
//         employeee.setEmail("murali.rajyam923@gmail.com");
//         employeee.setBloodGroup("o+");
//         employeee.setPhoneNumber("9878675634");
//         employeee.setSalary(80000);
//         employeee.setAddress(Arrays.asList("Hyderabad","Apoco colony"));
//          employeeeList.add(employeee);
//         return employeeeList;
//     }
// }
