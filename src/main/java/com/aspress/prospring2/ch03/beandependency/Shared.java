package com.aspress.prospring2.ch03.beandependency;

public class Shared {
	private static Object value=null;
	private Shared() { }
	
	public synchronized static void setValue(Object o) {
		value = o;
	}
	
	public static Object getValue() {
		return value;
	}
}
