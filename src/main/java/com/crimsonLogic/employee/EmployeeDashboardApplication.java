package com.crimsonLogic.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EmployeeDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDashboardApplication.class, args);
	}

}
