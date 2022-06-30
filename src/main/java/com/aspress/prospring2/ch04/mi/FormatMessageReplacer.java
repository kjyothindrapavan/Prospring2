package com.aspress.prospring2.ch04.mi;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class FormatMessageReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		String msg = (String)args[0];
		return "<h2>"+msg+"</h2>";
	}

}
