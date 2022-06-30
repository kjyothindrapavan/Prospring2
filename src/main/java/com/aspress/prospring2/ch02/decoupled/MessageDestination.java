package com.aspress.prospring2.ch02.decoupled;

public interface MessageDestination {
	void write(String message);
}
