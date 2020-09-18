package com.crimsonLogic.employee.exception;

public class EmployeeDashboardAppException extends Exception{

	private static final long serialVersionUID = 1L;

	public EmployeeDashboardAppException() {
		super();
	}

	public EmployeeDashboardAppException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmployeeDashboardAppException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeDashboardAppException(String message) {
		super(message);
	}

	public EmployeeDashboardAppException(Throwable cause) {
		super(cause);
	}
	

}
