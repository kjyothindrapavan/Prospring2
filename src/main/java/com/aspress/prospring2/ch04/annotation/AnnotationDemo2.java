package com.aspress.prospring2.ch04.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemo2 {

	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("/META-INF/ch04/annotationdemo2-context.xml");
		String[] beanNames = ac.getBeanDefinitionNames();
		for(String beanName:beanNames) {
			System.out.println(beanName+" : "+ac.getBean(beanName));
		}
		
	}

}
