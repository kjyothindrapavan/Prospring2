package com.aspress.prospring2.ch04.bfpp;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ObscenityCleaningDemo {

	public static void main(String[] args) {
		ConfigurableListableBeanFactory factory = new XmlBeanFactory(
				new ClassPathResource("/META-INF/ch04/bfpp2-context.xml"));
		
		BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) factory.getBean("bfpp");
		bfpp.postProcessBeanFactory(factory);
		System.out.println(factory.getBean("simpleBean"));
		System.out.println(factory.getBean("obscenitiesRemoved"));
	}

}
