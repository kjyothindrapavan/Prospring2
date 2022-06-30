package com.aspress.prospring2.ch04.lifecycle;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SimpleBeanDemo1 {

	public static void main(String[] args) {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/META-INF/ch04/lifecycledemo-context.xml"));
		System.out.println(factory.getBean("simple1"));
		System.out.println(factory.getBean("simple2"));
		System.out.println(factory.getBean("simple3"));
	}

}
