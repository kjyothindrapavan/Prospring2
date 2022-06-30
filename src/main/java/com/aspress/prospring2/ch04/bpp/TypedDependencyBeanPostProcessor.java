package com.aspress.prospring2.ch04.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class TypedDependencyBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
	
	@Override
	public Class predictBeanType(Class beanClass, String beanName) {
		if(beanClass.equals(Dependency.class))
			return String.class;
		return beanClass;
	}
	
	@Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        if (bean.getClass().equals(Dependency.class)) {
            return "Hello, world";
        }
        return bean;
    }

	@Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
