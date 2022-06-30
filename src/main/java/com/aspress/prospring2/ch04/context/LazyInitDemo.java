package com.aspress.prospring2.ch04.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyInitDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/ch04/acdemo2-context.xml");
		ctx.getBean("destructiveBean");
	}

}
