package com.aspress.prospring2.ch04.bpp;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SimpleBeanDemo2 {

	public static void main(String[] args) {
		ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(
				new ClassPathResource("/META-INF/ch04/bpp2-context.xml"));
		registerBeanPostProcessor(beanFactory, "bpp2");
		registerBeanPostProcessor(beanFactory,"bpp");
		registerBeanPostProcessor(beanFactory,"bpp3");
		registerBeanPostProcessor(beanFactory,"bpp4");
		
		SimpleBean sb = (SimpleBean)beanFactory.getBean("simpleBean");
		System.out.println(sb);
		beanFactory.destroySingletons();
	}
	
	private static void registerBeanPostProcessor(ConfigurableBeanFactory factory, String beanName) {
		BeanPostProcessor bpp = (BeanPostProcessor) factory.getBean(beanName);
		factory.addBeanPostProcessor(bpp);
	}
}

