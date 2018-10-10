package com.my.base;

public class SpringException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1323056880651537306L;
	
	private String exceptionMsg;

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public SpringException(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}
	
	

}
