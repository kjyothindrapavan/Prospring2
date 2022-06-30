package com.aspress.prospring2.ch04.context;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageSourceDemo {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/META-INF/ch04/acdemo3-context.xml");
		
		Locale english = Locale.ENGLISH;
		Locale czech = new Locale("cs","CZ");
		
		System.out.println(ac.getMessage("msg", null, english));
		System.out.println(ac.getMessage("msg", null, Locale.UK));
		System.out.println(ac.getMessage("msg", null, czech));
		System.out.println(ac.getMessage("hello", null, Locale.UK));
		
		System.out.println(ac.getMessage("nameMsg", new Object[] {"Jan", "Machacek"},english));
	}

}
