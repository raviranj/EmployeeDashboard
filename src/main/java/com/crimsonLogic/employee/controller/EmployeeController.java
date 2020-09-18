package com.crimsonLogic.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crimsonLogic.employee.entity.Employee;
import com.crimsonLogic.employee.exception.EmployeeDashboardAppException;
import com.crimsonLogic.employee.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	//@PostMapping("/createEmployee")
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@CacheEvict(cacheNames = "EmployeeList",allEntries=true)
	public ResponseEntity<String>  addEmployee(@RequestBody Employee employee) throws EmployeeDashboardAppException {
		return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.OK);
	}
	
	@GetMapping("/searchEmployee/{id}")
	@Cacheable(cacheNames = "Employee", key = "#id")
	public ResponseEntity<Employee> fetchEmployeeById(@PathVariable int id) throws EmployeeDashboardAppException{
		System.err.println("Fetching from DB...!");
		return new ResponseEntity<>(employeeService.fetchEmployeeById(id),HttpStatus.OK);
	}
	
	@GetMapping("/viewEmployees")
	@Cacheable(cacheNames = "EmployeeList",key="#p0", condition = "#p0!=null")
	public ResponseEntity<List<Employee>> getEmployees() throws EmployeeDashboardAppException{
		System.err.println("Fetching from DB...!");
		return new ResponseEntity<>(employeeService.getEmployees(),HttpStatus.OK);
	}
	
	@PutMapping("modifyEmployee")
	@CachePut(cacheNames = "Employee",key = "#employee.employeeId")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
		System.err.println("updating from DB...!");
		return new ResponseEntity<>(employeeService.updateEmpl(employee),HttpStatus.OK);
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	@CacheEvict(cacheNames = "Employee", key = "#id")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) throws EmployeeDashboardAppException{
		System.err.println("Deleting from Db...!");
		return new ResponseEntity<>(employeeService.deleteEmployee(id),HttpStatus.OK);
	}
	
}
