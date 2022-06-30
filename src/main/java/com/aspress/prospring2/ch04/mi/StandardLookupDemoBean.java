package com.aspress.prospring2.ch04.mi;

public class StandardLookupDemoBean implements DemoBean {
	private MyHelper helper;

	
	public void setMyHelper(MyHelper helper) {
		this.helper = helper;
	}
	
	@Override
	public MyHelper getMyHelper() {
		return this.helper;
	}

	@Override
	public void someOperation() {
		helper.doSomethingHelpful();
	}

}
