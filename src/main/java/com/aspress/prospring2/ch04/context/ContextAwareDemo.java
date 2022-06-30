package com.aspress.prospring2.ch04.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextAwareDemo implements ApplicationContextAware{
	
	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}
	
	public static void main(String...args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/ch04/acdemo1-context.xml");
		ContextAwareDemo demo = (ContextAwareDemo)ctx.getBean("contextAware");
		demo.displayAppContext();
	}
	
	public void displayAppContext() {
		System.out.println(this.ctx);
	}

}
