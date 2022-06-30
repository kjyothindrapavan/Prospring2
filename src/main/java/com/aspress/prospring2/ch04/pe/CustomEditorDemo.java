package com.aspress.prospring2.ch04.pe;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class CustomEditorDemo {
	private Complex[] values;
	
	public static void main(String...args) {
		ConfigurableListableBeanFactory factory = new XmlBeanFactory(
				new ClassPathResource("/META-INF/ch04/pedemo2-context.xml"));
		factory.addPropertyEditorRegistrar(new PropertyEditorRegistrar() {
			public void registerCustomEditors(PropertyEditorRegistry registry) {
					registry.registerCustomEditor(Complex.class, new ComplexPropertyEditor());
			}
		});
		
		CustomEditorDemo bean = (CustomEditorDemo) factory.getBean("exampleBean");
		System.out.println(bean.sum());
	}
	
	private Complex sum() {
		Complex result = new Complex(0d,0d);
		for(Complex value:this.values) {
			result = result.add(value);
		}
		return result;
	}
	
	public void setValues(Complex[] values) {
		this.values = values;
	}

}
