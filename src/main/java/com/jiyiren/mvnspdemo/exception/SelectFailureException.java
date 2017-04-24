package com.jiyiren.mvnspdemo.exception;

public class SelectFailureException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SelectFailureException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SelectFailureException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SelectFailureException(String message) {
		super("==查询异常:"+message);
		// TODO Auto-generated constructor stub
	}

	public SelectFailureException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
