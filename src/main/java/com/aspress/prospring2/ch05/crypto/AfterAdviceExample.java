package com.aspress.prospring2.ch05.crypto;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceExample {

	public static void main(String[] args) {
		KeyGenerator keyGen = getKeyGenerator();
		
		for(int x=0;x<10;x++) {
			try {
				long key = keyGen.getKey();
				System.out.println("Key: "+key);
			} catch(SecurityException ex) {
				System.out.println("Weak Key Generated! "+ex.getMessage());
			}
		}
	}
	
	private static KeyGenerator getKeyGenerator() {
		KeyGenerator target = new KeyGenerator();
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(new WeakKeyCheckAdvice());
		
		return (KeyGenerator)pf.getProxy();
	}

}
