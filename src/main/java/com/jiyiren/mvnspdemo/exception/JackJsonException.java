package com.jiyiren.mvnspdemo.exception;

public class JackJsonException extends RuntimeException {

	public JackJsonException(String msg) {
		super("==Json解析异常："+msg);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
