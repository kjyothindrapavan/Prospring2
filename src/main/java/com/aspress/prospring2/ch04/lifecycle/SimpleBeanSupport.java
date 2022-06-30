package com.aspress.prospring2.ch04.lifecycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class SimpleBeanSupport implements InitializingBean {
	private String value;
	
	/**
	 * SubClasses may override this method to perform additional initialization
	 * This method gets invoked after the intialization of the
	 * {@link SimpleBeanSupport} completes.
	 * @throws Exception If subclass initialization fails
	 */
	protected void initSimple() throws Exception { }
	
	public final void afterPropertiesSet() throws Exception {
		Assert.notNull(this.value, "The [value] property of ["+getClass().getName()+"] must be set");
		initSimple();
	}
	
	public final void setValue(String value) {
		this.value = value;
	}
	
	protected final String getValue() {
		return this.value;
	}
}
