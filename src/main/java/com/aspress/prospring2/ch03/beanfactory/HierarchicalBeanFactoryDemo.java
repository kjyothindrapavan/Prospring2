package com.aspress.prospring2.ch03.beanfactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class HierarchicalBeanFactoryDemo {

	public static void main(String[] args) {
		XmlBeanFactory parent = new XmlBeanFactory(new ClassPathResource("/META-INF/ch03/spring/injectdemo2-context.xml"));
		XmlBeanFactory child = new XmlBeanFactory(new ClassPathResource("/META-INF/ch03/spring/injectdemo3-context.xml"),parent);
		
		System.out.println(parent.getBean("injectSimpleParent"));
		System.out.println(child.getBean("injectSimpleChild"));
		System.out.println(child.getBean("injectSimpleChild2"));
	}

}
