package com.aspress.prospring2.ch03.ioc;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.aspress.prospring2.ch02.spring.MessageService;

public class ContextualizedDependencyLookupDemo {
	private static Set<ManagedComponent> components = new HashSet<ManagedComponent>();
	
	private static class MessageServiceComponent implements ManagedComponent {
		MessageService service;
		
		@Override
		public void lookup(BeanFactory container) {
			this.service = (MessageService)container.getBean("service");
		}
		
		public void run() {
			this.service.execute();
		}
	}

	public static void main(String[] args) {
		BeanFactory bf = getBeanFactory();
		MessageServiceComponent msc = new MessageServiceComponent();
		registerComponent(msc);
		allowComponentsLookup(bf);
		msc.run();
	}
	
	private static void allowComponentsLookup(BeanFactory bf) {
		for(ManagedComponent component:components) {
			component.lookup(bf);
		}
	}

	private static BeanFactory getBeanFactory() {
		DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new PropertiesBeanDefinitionReader(bf);
		reader.loadBeanDefinitions(new ClassPathResource("/META-INF/ch03/spring/ioc-pull-context.properties"));
		return bf;
	}
	
	private static void registerComponent(MessageServiceComponent messagedcomponent) {
		components.add(messagedcomponent);
	}
}
