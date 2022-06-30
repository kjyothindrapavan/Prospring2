package com.aspress.prospring2.ch04.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventPublisherDemo implements ApplicationContextAware {
	private ApplicationContext ctx;
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/ch04/eventsdemo1-context.xml");
		EventPublisherDemo pub = (EventPublisherDemo) ctx.getBean("publisher");
		pub.publish("Hello World!");
		pub.publish("The quick brown fox jumped over the lazy dog");
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;

	}
	
	public void publish(String message) {
		ctx.publishEvent(new MessageEvent(this,message));
	}

}
