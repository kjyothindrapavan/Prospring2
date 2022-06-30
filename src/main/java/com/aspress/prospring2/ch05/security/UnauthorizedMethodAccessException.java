package com.aspress.prospring2.ch05.security;

public class UnauthorizedMethodAccessException extends SecurityException {
	
	private String userName;
	private String methodName;
	
	public UnauthorizedMethodAccessException(String msg, String userName,String methodName) {
		super(msg);
		this.userName= userName;
		this.methodName = methodName;
	}

	public String getUserName() {
		return userName;
	}

	public String getMethodName() {
		return methodName;
	}
	
	

}
