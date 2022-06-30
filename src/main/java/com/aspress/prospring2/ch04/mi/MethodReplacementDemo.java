package com.aspress.prospring2.ch04.mi;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StopWatch;

public class MethodReplacementDemo {
	static interface StressTestCallback{
		void run(ReplacementTarget target);
	}
	public static void main(String[] args) {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("META-INF/ch04/midemo3-context.xml"));
		StressTestCallback stringCallback = new StressTestCallback() {
			private final String msg = "Hello";
			public void run(ReplacementTarget target) {
				target.formatMessage(msg);
			}
			
			@Override
			public String toString() {
				return "formatMessage(String)";
			}
		};
		StressTestCallback objectCallback = new StressTestCallback() {
			private final Object msg = new Object();
			
			public void run(ReplacementTarget target) {
				target.formatMessage(msg);
			}
			
			@Override
			public String toString() {
				return "formatMessage(Object)";
			}
		};
		StressTest(factory,"replacementTarget",stringCallback);
		StressTest(factory,"standardTarget",stringCallback);
		StressTest(factory,"replacementTarget",objectCallback);
		StressTest(factory,"standardTarget",objectCallback);
	}
	private static void StressTest(XmlBeanFactory factory,String beanName,StressTestCallback callback) {
		ReplacementTarget target = (ReplacementTarget)factory.getBean(beanName);
		callback.run(target);
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("perfTest");
		for(int i=0;i<1000000;i++) {
			callback.run(target);
		}
		stopWatch.stop();
		System.out.println("1000000 invocations of formatMessage("+callback+") on "+beanName+" took: "+stopWatch.getTotalTimeMillis()+" ms");
	}
}
