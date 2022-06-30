package com.aspress.prospring2.ch05.security;

public class UnVerifiedMethodAccessException extends SecurityException {
	
	private String methodName;
	
	public UnVerifiedMethodAccessException(String msg,String methodName) {
		super(msg);
		this.methodName = methodName;
	}
	
	public String getMethodName() {
		return this.methodName;
	}

}
