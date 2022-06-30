package com.aspress.prospring2.ch04.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemo1 {

	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("/META-INF/ch04/annotationdemo1-context.xml");
		System.out.println(ac.getBean("simplestBean"));
	}

}
