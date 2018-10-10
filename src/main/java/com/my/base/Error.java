package com.my.base;

public enum Error{	
	
	S001("S001","Success"),
	E001("E001","System error!"),
	E002("E002","Sorroy,user cannot find in database!"),
	E003("E003","Unknow error!");
	
	private String errorCode;
	private String errorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	private Error(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	
	
	
	
	
	
}
