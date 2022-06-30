package com.aspress.prospring2.ch04.annotation;

@Magic
public class SimpleBean {
	 @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder();
	        sb.append("SimpleBean");
	        sb.append("{}");
	        return sb.toString();
	    }
}
