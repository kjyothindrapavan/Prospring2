package com.aspress.prospring2.ch04.lifecycle;

import org.springframework.util.Assert;

public class SoutSimpleBean extends SimpleBeanSupport {
	private String person;
	
	@Override
	protected void initSimple() throws Exception {
		Assert.notNull(this.person,"The [person] property of ["+getClass().getName()+"] must be set");
	}
	
	public void setPerson(String person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		return String.format("%s says \"%s\"", this.person,getValue());
	}
}
