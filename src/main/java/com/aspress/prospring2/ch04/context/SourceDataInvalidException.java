package com.aspress.prospring2.ch04.context;

import org.springframework.core.NestedRuntimeException;

public class SourceDataInvalidException extends NestedRuntimeException {
	 private static final long serialVersionUID = -4844180669945134483L;
	 private int length;

	public SourceDataInvalidException(String msg, int length) {
		super(msg);
		this.length = length;
	}
	
	public int getLength() { return this.length;}

}
