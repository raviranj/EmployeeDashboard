package com.crimsonLogic.employee.dao.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crimsonLogic.employee.dao.EmployeeDao;
import com.crimsonLogic.employee.entity.Employee;
import com.crimsonLogic.employee.repository.EmployeeRepository;

@Service
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Optional<Employee> fetchEmployeeById(int id) {
		return employeeRepo.findById(id);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public void deleteEmployee(int id) {
		 employeeRepo.deleteById(id);
	}

	@Override
	public Object updateEmployee(Employee employee) {
		return employeeRepo.saveAndFlush(employee);
	}

}
