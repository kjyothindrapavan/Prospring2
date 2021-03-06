package com.aspress.prospring2.ch03.dependencycheck;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class DependencyCheckDemo {
	public static void main(String[] args) {
        XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("/META-INF/ch03/spring/depcheckdemo1-context.xml"));

        System.out.println(bf.getBean("target1"));
        System.out.println(bf.getBean("target2"));
        System.out.println(bf.getBean("target3"));
    }
}
