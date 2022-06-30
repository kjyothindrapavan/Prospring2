package com.aspress.prospring2.ch04.annotation;

public class MarkedBean implements ComponentMarker {
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
        sb.append("MarkedBean");
        sb.append("{}");
        return sb.toString();
	}

}
