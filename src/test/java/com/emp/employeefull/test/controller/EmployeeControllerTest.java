package com.emp.employeefull.test.controller;

import com.emp.employeefull.controller.EmployeeController;
import com.emp.employeefull.entity.Employee;
import com.emp.employeefull.serviceImpl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeServiceImpl employeeService;

    @Test
    void getEmployeeSuccess() throws Exception {

        Employee emp = new Employee();
        emp.setId(1L);
        emp.setFullName("Murali");

        when(employeeService.getByEmployeeId(1L)).thenReturn(emp);

        mockMvc.perform(get("/employees/getEmployee/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("Murali"));
    }

}
