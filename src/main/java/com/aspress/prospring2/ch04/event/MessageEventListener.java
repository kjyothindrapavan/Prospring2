package com.aspress.prospring2.ch04.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof MessageEvent) {
			MessageEvent messageEvent = (MessageEvent) event;
			System.out.println("Received "+messageEvent.getMessage()+
					" from "+messageEvent.getSource());
		}
		
	}
}
