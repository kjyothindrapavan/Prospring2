package com.aspress.prospring2.ch03.beanfactory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.aspress.prospring2.ch03.di.Oracle;

public class XmlBeanFactoryDemo {
	public static void main(String...args) {
		XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("/META-INF/ch03/spring/beanfactorydemo1-context.xml"));
		Oracle oracle = (Oracle) bf.getBean("oracle");
		System.out.println("Meaning of life is "+oracle.defineMeaningOfLife());
		
		//constructor injection using util:map and entry
		bf = new XmlBeanFactory(new ClassPathResource("/META-INF/ch03/spring/beanfactorydemo2-context.xml"));
		oracle = (Oracle)bf.getBean("oracle");
		System.out.println("Meaning of life is constructor "+oracle.defineMeaningOfLife());
		
		bf = new XmlBeanFactory(new ClassPathResource("/META-INF/ch03/spring/beanfactorydemo2p-context.xml"));
		oracle = (Oracle)bf.getBean("oracle");
		System.out.println("Meaning of life is constructor "+oracle.defineMeaningOfLife());
	}
}
