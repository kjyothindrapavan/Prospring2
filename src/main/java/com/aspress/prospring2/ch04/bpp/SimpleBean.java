package com.aspress.prospring2.ch04.bpp;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class SimpleBean implements InitializingBean{
	@Timestamp
	Date creationDate;
	
	@Autowired
	String dependency;
	
	@PostConstruct
	public void initialize() {
		System.out.println("Intializing Bean "+getClass());
		System.out.println("Intializing Bean 2 "+this.creationDate);
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("cleaning up bean "+ getClass());
	}
	
	@Override
	public String toString() {
		return "Bean was created at "+this.creationDate;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("after properties set");
		System.out.println("after properties set 2 "+this.creationDate);
	}
//
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("destroy method");
//	}
	
	

}
