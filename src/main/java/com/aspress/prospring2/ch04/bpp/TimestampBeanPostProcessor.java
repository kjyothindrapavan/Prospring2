package com.aspress.prospring2.ch04.bpp;

import java.lang.reflect.Field;
import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

public class TimestampBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(final Object bean,final String beanName) throws BeansException {
		ReflectionUtils.doWithFields(bean.getClass(), 
				new ReflectionUtils.FieldCallback() {
					
					@Override
					public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
						field.set(bean, new Date());
					}
				}, new ReflectionUtils.FieldFilter() {
					
					@Override
					public boolean matches(Field field) {
						return field.getType()==Date.class &&
								field.getAnnotation(Timestamp.class)!=null;
					}
				});
		
		return bean;
		
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
		//return null;
	}

}
