package com.crimsonLogic.employee.service;

import java.util.List;

import com.crimsonLogic.employee.entity.Employee;
import com.crimsonLogic.employee.exception.EmployeeDashboardAppException;

public interface EmployeeService {

	String addEmployee(Employee employee) throws EmployeeDashboardAppException;

	Employee fetchEmployeeById(int id) throws EmployeeDashboardAppException;

	List<Employee> getEmployees() throws EmployeeDashboardAppException;

	String deleteEmployee(int id) throws EmployeeDashboardAppException;

	Object updateEmpl(Employee employee);

}
