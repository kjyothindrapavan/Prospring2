package com.aspress.prospring2.ch04.interaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class ShutDownHookBean implements Runnable, BeanFactoryAware {
	private static final Log logger = LogFactory.getLog(ShutDownHookBean.class);
	private ConfigurableListableBeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		//System.out.println("inside setBeanFactory");
		if(beanFactory instanceof DefaultListableBeanFactory) {
			System.out.println("inside if statement");
			this.beanFactory = (ConfigurableListableBeanFactory)beanFactory;
			Runtime.getRuntime().addShutdownHook(new Thread(this));
		}
	}

	@Override
	public void run() {
		if(beanFactory!=null) {
			logger.info("Destroying Singletons");
			this.beanFactory.destroySingletons();
		}
	}

}
