package com.aspress.prospring2.ch04.factory;

import java.security.MessageDigest;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MessageDigestDemo {
	public static void main(String...args) {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("META-INF/ch04/factorydemo-context.xml"));
		MessageDigest d1 = (MessageDigest)factory.getBean("sha");
		MessageDigest d2 = (MessageDigest)factory.getBean("md5");
		calculateDigest("Hello, world",d1);
		calculateDigest("Hello, world",d2);
	}
	
	private static void calculateDigest(String message,MessageDigest digest) {
		System.out.print("Digest using "+digest.getAlgorithm()+": ");
		digest.reset();
		final byte[] bytes = digest.digest(message.getBytes());
		for(byte b: bytes) {
			System.out.print(String.format("%02x", b));
		}
		System.out.println("");
	}
}
