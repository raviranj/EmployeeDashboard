package com.crimsonLogic.employee.exception;

public class InputMisMatchException extends EmployeeDashboardAppException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputMisMatchException() {
		super();
	}

	public InputMisMatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InputMisMatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public InputMisMatchException(String message) {
		super(message);
	}

	public InputMisMatchException(Throwable cause) {
		super(cause);
	}
	
	

}
