package com.aspress.prospring2.ch05.profiling;

import org.springframework.aop.framework.ProxyFactory;

public class ProfilingExample {
	public static void main(String[] args) {
		WorkBean bean = getWorkBean();
		bean.doSomeWork(10000000);
		
	}
	
	private static WorkBean getWorkBean() {
		WorkBean target = new WorkBean();
		
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(new ProfilingInterceptor());
		
		return (WorkBean)pf.getProxy();
	}
}
