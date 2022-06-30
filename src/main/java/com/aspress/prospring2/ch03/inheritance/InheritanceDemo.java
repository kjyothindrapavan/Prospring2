package com.aspress.prospring2.ch03.inheritance;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class InheritanceDemo {
	public static void main(String...args) {
	XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("/META-INF/ch03/spring/inheritancedemo1-context.xml"));
	System.out.println(bf.getBean("bean1"));
	System.out.println(bf.getBean("bean2"));
	}
}
