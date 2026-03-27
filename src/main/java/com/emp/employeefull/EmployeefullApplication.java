package com.emp.employeefull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeefullApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeefullApplication.class, args);
	}


}
