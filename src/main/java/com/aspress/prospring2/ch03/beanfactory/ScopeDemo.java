package com.aspress.prospring2.ch03.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ScopeDemo {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(
				new ClassPathResource("META-INF/ch03/spring/beanscopedemo1-context.xml"));
		compare(factory,"singleMe");
		compare(factory,"prototypeMe");
	}

	private static void compare(BeanFactory factory, String beanName) {
		String s1 = (String)factory.getBean(beanName);
		String s2 = (String)factory.getBean(beanName);
		
		System.out.println("bean s1 = "+s1+" bean s2 = "+s2);
		System.out.println("same? "+(s1==s2));
		System.out.println("Equal? "+(s1.equals(s2)));
	}

}
