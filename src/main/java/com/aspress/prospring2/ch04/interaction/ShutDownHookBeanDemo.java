package com.aspress.prospring2.ch04.interaction;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ShutDownHookBeanDemo {
	public static void main(String...args) {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("META-INF/ch04/interactiondemo2-context.xml"));
		factory.preInstantiateSingletons();
		LoggingBean lb = (LoggingBean)factory.getBean("logging");
		lb.run();
	}
}
