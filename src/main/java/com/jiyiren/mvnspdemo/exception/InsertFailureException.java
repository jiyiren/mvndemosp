package com.jiyiren.mvnspdemo.exception;

public class InsertFailureException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsertFailureException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsertFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InsertFailureException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InsertFailureException(String message) {
		super("==插入异常："+message);
		// TODO Auto-generated constructor stub
	}

	public InsertFailureException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
