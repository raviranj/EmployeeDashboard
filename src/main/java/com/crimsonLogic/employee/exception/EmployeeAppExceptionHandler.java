package com.crimsonLogic.employee.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crimsonLogic.employee.controller.EmployeeController;

@RestControllerAdvice(assignableTypes = EmployeeController.class)
public class EmployeeAppExceptionHandler {
	
	@ExceptionHandler(EmployeeDashboardAppException.class)
	public ResponseEntity<Map<String, Object>> EmployeeAppExceptionHandler(Exception e, Throwable t){
		Map<String, Object> response = new HashMap<>();
		response.put("Error", true);
		response.put("Message", e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InputMisMatchException.class)
	public ResponseEntity<Map<String, Object>> inputMisMatchExceptionHandler(Exception e, Throwable t){
		Map<String, Object> response = new HashMap<>();
		response.put("Error", true);
		response.put("Message", e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
