package com.aspress.prospring2.ch05.simple;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] arg, Object target) throws Throwable {
		System.out.println("");
		System.out.println("After method: "+method.getName());
	}

	public static void main(String[] args) {
		MessageWriter target = new MessageWriter();
		
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(new SimpleAfterReturningAdvice());
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		
		proxy.writeMessage();
	}

}
