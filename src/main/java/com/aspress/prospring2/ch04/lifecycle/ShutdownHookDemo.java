package com.aspress.prospring2.ch04.lifecycle;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ShutdownHookDemo {
	public static void main(String...args) {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/META-INF/ch04/lifecycledemo5-context.xml"));
		System.out.println(factory.getBean("destructive"));
		Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHook(factory)));
	}
}
