package com.codegym.manageremployeehotel;

import com.codegym.manageremployeehotel.service.EmployeeService;
import com.codegym.manageremployeehotel.service.EmployeeServiceImpl;
import com.codegym.manageremployeehotel.service.TeamService;
import com.codegym.manageremployeehotel.service.TeamServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManagerEmployeeHotelApplication {
	@Bean
	public EmployeeService employeeService() {
		return new EmployeeServiceImpl();
	}
	@Bean
	public TeamService teamService() {
		return new TeamServiceImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(ManagerEmployeeHotelApplication.class, args);
	}
}
