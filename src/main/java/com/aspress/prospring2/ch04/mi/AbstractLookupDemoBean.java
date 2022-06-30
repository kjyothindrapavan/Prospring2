package com.aspress.prospring2.ch04.mi;

public abstract class  AbstractLookupDemoBean implements DemoBean {

	@Override
	public abstract MyHelper getMyHelper();

	@Override
	public void someOperation() {
		getMyHelper().doSomethingHelpful();
	}

}
