package com.aspress.prospring2.ch04.bfpp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor, BeanNameAware {
	
	private Set<String> obscenities;
	private Set<String> removedObscenities;
	private String name;
	
	public ObscenityRemovingBeanFactoryPostProcessor() {
		this.obscenities = new HashSet<>();
		this.removedObscenities = new HashSet<String>();
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		for(String beanName:beanNames) {
			if(beanName.equals(this.name)) continue;
			BeanDefinition beanDefiniton = beanFactory.getBeanDefinition(beanName);
			StringValueResolver valueResolver = new StringValueResolver() {
				
				@Override
				public String resolveStringValue(String strVal) {
					if(isObscene(strVal)) { 
						removedObscenities.add(strVal);
						return "***";}
					return strVal;
				}
			};
			
			BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
			visitor.visitBeanDefinition(beanDefiniton);
		}
		
		beanFactory.registerSingleton("obscenitiesRemoved", this.removedObscenities);
	}
	
	private boolean isObscene(Object value) {
		String potentialObscenity = value.toString().toUpperCase();
		return this.obscenities.contains(potentialObscenity);
	}

	public void setObscenities(Set<String> obscenities) {
		this.obscenities.clear();
		for(String obscenity:obscenities) {
			this.obscenities.add(obscenity.toUpperCase());
		}
	}

	@Override
	public void setBeanName(String name) {
		this.name = name;
	}
	
	
}
