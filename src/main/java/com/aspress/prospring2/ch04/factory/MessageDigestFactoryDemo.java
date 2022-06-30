package com.aspress.prospring2.ch04.factory;

import java.security.MessageDigest;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MessageDigestFactoryDemo {

	public static void main(String[] args) throws Exception {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("META-INF/ch04/factorydemo-context.xml"));
		MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean)factory.getBean("&sha");
		MessageDigest d1 = (MessageDigest)factory.getBean("sha");
		MessageDigest d2 = (MessageDigest)factoryBean.getObject();
		System.out.println("Equal MessageDigests Created? "+
				(d1.getAlgorithm().equals(d2.getAlgorithm())));
	}

}
