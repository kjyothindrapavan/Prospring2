package com.aspress.prospring2.ch02.decoupled.beanfactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
	private Map<String,String> beanDefinitions;
	
	public BeanFactory(String beanDefinitionSource) {
		readBeanDefinitions(beanDefinitionSource);
	}
	
	private void readBeanDefinitions(String beanDefinitionSource) {
		Properties props = new Properties();
		InputStream is = BeanFactory.class.getResourceAsStream(beanDefinitionSource);
		if(is==null) {
			throw new RuntimeException("could not load properties file "+ beanDefinitionSource);
		}
		try {
			props.load(is);
			is.close();
			this.beanDefinitions = new HashMap<String,String>();
			for(Map.Entry<Object, Object> entry:props.entrySet()) {
				this.beanDefinitions.put(entry.getKey().toString(), entry.getValue().toString());
			}
		}catch(IOException e) {
			throw new RuntimeException("could not read the properties file "+beanDefinitionSource);
		}
	}
	
	public Object getBean(String name) {
		String className = this.beanDefinitions.get(name);
		if(className == null) return null;
		try {
			return Class.forName(className).newInstance();
		}catch(Exception e) {
			//throw new RuntimeException("could not create bean with name "+name+e);
		     System.out.println(e);
		}
		return null;
	}
}
