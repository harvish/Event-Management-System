package com.ems.exceptions;

public class DatabaseExceptions extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DatabaseExceptions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatabaseExceptions(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DatabaseExceptions(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DatabaseExceptions(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DatabaseExceptions(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	private String errorMessage;
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	private String errorCode;

}
