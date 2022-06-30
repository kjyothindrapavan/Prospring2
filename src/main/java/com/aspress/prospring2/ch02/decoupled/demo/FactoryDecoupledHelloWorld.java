package com.aspress.prospring2.ch02.decoupled.demo;

import com.aspress.prospring2.ch02.decoupled.MessageDestination;
import com.aspress.prospring2.ch02.decoupled.MessageSource;
import com.aspress.prospring2.ch02.decoupled.beanfactory.BeanFactory;

public class FactoryDecoupledHelloWorld {

	public static void main(String[] args) {
		BeanFactory bf = new BeanFactory("/META-INF/plain/helloworld-context.properties");
		MessageSource ms = (MessageSource) bf.getBean("source");
		MessageDestination destinamtion = (MessageDestination) bf.getBean("destination");
		destinamtion.write(ms.getMessage());
	}

}
