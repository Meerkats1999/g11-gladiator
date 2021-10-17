package com.lti.appl.insurance.exceptions;

public class InsuranceServiceException extends Exception {

	public InsuranceServiceException() {
		super();
		
	}

	public InsuranceServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public InsuranceServiceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InsuranceServiceException(String message) {
		super(message);
		
	}

	public InsuranceServiceException(Throwable cause) {
		super(cause);
	
	}

}