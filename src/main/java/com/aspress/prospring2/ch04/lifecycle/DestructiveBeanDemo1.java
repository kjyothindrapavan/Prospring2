package com.aspress.prospring2.ch04.lifecycle;

import java.io.BufferedInputStream;
import java.io.IOException;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class DestructiveBeanDemo1 {
	public static void main(String...args) throws IOException {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/META-INF/ch04/lifecycledemo4-context.xml"));
		System.out.println(factory.getBean("destructive"));
		//new BufferedInputStream(System.in).read();
		factory.destroySingletons();
		System.out.println("Almost done!");
		//new BufferedInputStream(System.in).read();
	}
}
