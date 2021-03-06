package com.aspress.prospring2.ch04.event;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {
	private static final long serialVersionUID = -6786033091498612636L;
	private String message;

	public MessageEvent(Object source, String message) {
		super(source);
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
