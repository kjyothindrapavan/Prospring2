package com.aspress.prospring2.ch04.lifecycle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class DestructiveBeanDB implements InitializingBean,DisposableBean {
	private InputStream is =null;
	private String filePath = null;
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying Bean");
		if(this.is!=null) {
			try {
				this.is.close();
				this.is = null;
				new File(this.filePath).delete();
			} catch(IOException ex) {
				System.err.println("WARN: An IOException occured while trying to close the InputStream");
			}
		}
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Bean");
		Assert.notNull(this.filePath,"The [filePath] property of ["+getClass().getName()+"] must be set");
		
		new File(this.filePath).createNewFile();
		this.is = new FileInputStream(this.filePath);
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	 @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder();
	        sb.append("DestructiveBeanDB");
	        sb.append("{is=").append(is);
	        sb.append(", filePath='").append(filePath).append('\'');
	        sb.append('}');
	        return sb.toString();
	    }
	
}
