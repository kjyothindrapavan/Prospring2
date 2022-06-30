package com.aspress.prospring2.ch05.simple;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
	
	public static void main(String[] args) {
		MessageWriter writer = new MessageWriter();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new SimpleBeforeAdvice());
		pf.setTarget(writer);
		
		MessageWriter proxy = (MessageWriter) pf.getProxy();
		proxy.writeMessage();
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Befor Method: "+method.getName());
	}

}
