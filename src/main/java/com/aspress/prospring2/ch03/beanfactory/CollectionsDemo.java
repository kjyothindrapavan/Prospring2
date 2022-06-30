package com.aspress.prospring2.ch03.beanfactory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;



public class CollectionsDemo {
	private Map map;
	private List list;
	private Set set;
	private Properties props;
	
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(
				new ClassPathResource("/META-INF/ch03/spring/collectionsdemo1-context.xml"));
		CollectionsDemo instance = 
				(CollectionsDemo) factory.getBean("collectionsDemo");
		instance.displayInfo();
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public void setList(List list) {
		this.list = list;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public void setProps(Properties props) {
		this.props = props;
	}
	
	public void displayInfo() {
		Iterator i = map.keySet().iterator();
		System.out.println("Map Contents\n");
		while(i.hasNext()) {
			Object key = i.next();
			System.out.println("Key: "+key+" - Value: "+map.get(key));
		}
		
		i=props.keySet().iterator();
		System.out.println("\nProperties Contents:\n");
		while(i.hasNext()) {
			String key = i.next().toString();
			System.out.println("Key: "+key+" - Value: "+props.getProperty(key));
		}
		
		i=list.iterator();
		System.out.println("\nList Contents\n");
		while(i.hasNext()) {
			System.out.println("Value: "+i.next());
		}
		
		i=set.iterator();
		System.out.println("\nSet Contents\n");
		while(i.hasNext()) {
			System.out.println("Value: "+i.next());
		}
	}
}
