package com.aspress.prospring2.ch04.context;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ErrorReportingDemo {
	private static void run(ApplicationContext context, Locale locale, 
			ErrorReporter reporter, double[] values) {
		try {
			reporter.evaluate(values);
		} catch (SourceDataInvalidException ex) {
			System.out.println(context.getMessage(ex.getMessage(), new Object[] {ex.getLength()},locale));
		} catch(ArgumentDomainException ex) {
			System.out.println(context.getMessage(ex.getMessage(), new Object[] {ex.getArgument()},locale));
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/ch04/acdemo4-context.xml");
		ErrorReporter reporter = (ErrorReporter) ctx.getBean("errorReporter");
		Locale en_GB = new Locale("en","GB");
		Locale cs_CZ = new Locale("cs", "CZ");
		run(ctx, en_GB, reporter, new double[] {1});
		run(ctx, en_GB, reporter, new double[] {1, -2});
		run(ctx, en_GB, reporter, new double[] {1, 3});
		run(ctx, cs_CZ, reporter, new double[] {1});
		run(ctx, cs_CZ, reporter, new double[] {1,-2});
		run(ctx, cs_CZ, reporter, new double[] {1,3});
	}
}
