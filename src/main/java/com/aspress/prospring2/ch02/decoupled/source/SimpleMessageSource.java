package com.aspress.prospring2.ch02.decoupled.source;

import com.aspress.prospring2.ch02.decoupled.MessageSource;

public class SimpleMessageSource implements MessageSource {
private final String message;
public SimpleMessageSource() {
	this("Hello, World");
}
public SimpleMessageSource(String message) {
	this.message = message;
}
	@Override
	public String getMessage() {
		return message;
	}

}
