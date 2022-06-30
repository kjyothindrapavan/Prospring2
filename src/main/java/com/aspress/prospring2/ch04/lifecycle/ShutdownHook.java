package com.aspress.prospring2.ch04.lifecycle;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class ShutdownHook implements Runnable {
	ConfigurableListableBeanFactory factory;
	public ShutdownHook(ConfigurableListableBeanFactory factory) {
		this.factory = factory;
	}

	@Override
	public void run() {
		this.factory.destroySingletons();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
