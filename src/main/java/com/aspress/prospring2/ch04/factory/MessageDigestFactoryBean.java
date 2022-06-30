package com.aspress.prospring2.ch04.factory;

import java.security.MessageDigest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageDigestFactoryBean implements FactoryBean, InitializingBean {
	
	private static final String DEFAULT_ALGORITHM = "MD5";
	
	private String algorithm = DEFAULT_ALGORITHM;
	private MessageDigest messageDigest;
	
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.messageDigest = MessageDigest.getInstance(algorithm);
	}

	@Override
	public Object getObject() throws Exception {
		return this.messageDigest;
	}

	@Override
	public Class getObjectType() {
		return MessageDigest.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
	

}
