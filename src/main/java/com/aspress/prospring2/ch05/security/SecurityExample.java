package com.aspress.prospring2.ch05.security;

import java.util.Locale;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SecurityExample {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/ch05/bfsecuritydemo-context.xml");
		Locale locale = new Locale("en","GB");
		SecurityManager mgr = new SecurityManager();
		
		SecureBean bean = getSecureBean();
		
		mgr.login("janm", "######");
		bean.writSecureMessage();
		mgr.logout();
		
		try {
			mgr.login("aleksav", "$$$$$$");
			bean.writSecureMessage();
		} catch(UnauthorizedMethodAccessException ex) {
			System.out.println("Exception Caught: "+ ctx.getMessage(ex.getMessage(), 
					new Object[]{ex.getUserName(), ex.getMethodName()}, locale));
		} finally {
			mgr.logout();
		}
		
		try {
			bean.writSecureMessage();
		} catch(UnVerifiedMethodAccessException ex) {
			System.out.println("Exception Caught: "+ctx.getMessage(ex.getMessage(), 
					new Object[]{ex.getMethodName()}, locale));
		}
	}
	
	private static SecureBean getSecureBean() {
		SecureBean target = new SecureBean();
		ProxyFactory pf = new ProxyFactory();
		
		pf.addAdvice(new SecurityAdvice());
		pf.setTarget(target);
		
		return (SecureBean)pf.getProxy();
	}
}
