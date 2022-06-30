package com.aspress.prospring2.ch04.annotation;

import org.springframework.stereotype.Component;

@Component("mostComplicatedBean")
public class SimplestBean {
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("simplestBean");
		sb.append("{}");
		return sb.toString();
	}
}
