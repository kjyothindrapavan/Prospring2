package com.aspress.prospring2.ch04.mi;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class BeanFactoryAwareLookupDemoBean implements BeanFactoryAware, DemoBean {
	private BeanFactory beanFactory;
	@Override
	public MyHelper getMyHelper() {
		return (MyHelper)this.beanFactory.getBean("helper");
	}

	@Override
	public void someOperation() {
		getMyHelper().doSomethingHelpful();
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;

	}

}
