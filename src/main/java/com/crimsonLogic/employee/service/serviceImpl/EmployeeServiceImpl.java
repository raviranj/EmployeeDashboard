package com.crimsonLogic.employee.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crimsonLogic.employee.dao.EmployeeDao;
import com.crimsonLogic.employee.entity.Employee;
import com.crimsonLogic.employee.exception.EmployeeDashboardAppException;
import com.crimsonLogic.employee.exception.EmployeeNotFoundException;
import com.crimsonLogic.employee.exception.InputMisMatchException;
import com.crimsonLogic.employee.exception.NameFormatException;
import com.crimsonLogic.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	private static final String name_exp = "^[a-zA-Z\\s]+$";

	@Override
	public String addEmployee(Employee employee) throws EmployeeDashboardAppException {
		Employee employeeAdded = employeeDao.addEmployee(employee);
		return "Employee Added Successfully WITH Employee ID - " + employeeAdded.getEmployeeNo();
	}

	@Override
	public Employee fetchEmployeeById(int id) throws EmployeeDashboardAppException {
		if (id < 1) {
			throw new InputMisMatchException("Employee ID Should not be negative value..!");
		}
		Optional<Employee> employeeFetched = employeeDao.fetchEmployeeById(id);
		if (!employeeFetched.isPresent()) {
			throw new EmployeeNotFoundException("Employee by ID - " + id + " does not exists...!");
		}
		return employeeFetched.get();
	}

	@Override
	public List<Employee> getEmployees() throws EmployeeDashboardAppException {
		List<Employee> employees;
		employees = employeeDao.getEmployees();
		if (employees.isEmpty()) {
			throw new EmployeeNotFoundException("Employees Not Found in DB..!");
		}
		return employees;
	}

	@Override
	public String deleteEmployee(int id) throws EmployeeDashboardAppException {
		if (id < 1) {
			throw new InputMisMatchException("Employee ID  Should not be negative");
		}
		employeeDao.deleteEmployee(id);
		return "Employee with ID -" + id + " Has been deleted SuccessFully..!";
	}

	@Override
	public Object updateEmpl(Employee employee) {
		Employee emp = employeeDao.fetchEmployeeById(employee.getEmployeeNo()).get();
		if (employee != null) {
			if (!employee.getEmployeeName().isEmpty()) {
				emp.setEmployeeName(employee.getEmployeeName());
			}
			if (!employee.getEmployeeEmailId().isEmpty()) {
				emp.setEmployeeEmailId(employee.getEmployeeEmailId());
			}
			if (!employee.getStatus().isEmpty()) {
				emp.setStatus(employee.getStatus());
			}
			if (!employee.getAddress().isEmpty()) {
				emp.setAddress(employee.getAddress());
			}
		}
		return employeeDao.updateEmployee(emp);
	}
}
