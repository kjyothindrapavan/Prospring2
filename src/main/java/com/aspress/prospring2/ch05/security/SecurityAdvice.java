package com.aspress.prospring2.ch05.security;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {
	
	private SecurityManager securityManager;
	
	public SecurityAdvice() {
		this.securityManager = new SecurityManager();
	}

	@Override
	public void before(Method method, Object[] arg1, Object arg2) throws Throwable {
		UserInfo user = securityManager.getLoggedOnUser();
		
		if(user==null) {
			System.out.println("No user authenticated");
			throw new UnVerifiedMethodAccessException(
					"@com.aspress.prospring2.ch05.security.notlogged",method.getName());
		} else if("janm".equals(user.getUserName())) {
			System.out.println("Logged in user is janm -  OKAY!");
		} else {
			System.out.println("Logged in user is "+user.getUserName()+" NOT GOOD :(");
			throw new UnauthorizedMethodAccessException(
					"@Com.aspress.prospirng2.ch05.security.notauthorized", 
					user.getUserName(), method.getName());
		}
	}

}
