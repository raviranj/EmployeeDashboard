package com.crimsonLogic.employee.dao;

import java.util.List;
import java.util.Optional;

import com.crimsonLogic.employee.entity.Employee;

public interface EmployeeDao {

	Employee addEmployee(Employee employee);

	Optional<Employee> fetchEmployeeById(int id);

	List<Employee> getEmployees();

	void deleteEmployee(int id);

	Object updateEmployee(Employee employee);

}
