package com.aspress.prospring2.ch04.pe;

public final class Complex {
	private double re;
	private double im;
	
	public Complex(Double re, Double im) {
		if(re != null) this.re = re;
		if(im != null) this.im = im;
	}
	
	public double getRe() {
		return this.re;
	}
	
	public double getIm() {
		return this.im;
	}
	
	public Complex add(Complex rhs) {
		return new Complex(this.re+rhs.re,this.im+rhs.im);
	}
	
	@Override
	  public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("(").append(this.re);
        if (this.im > 0) sb.append("+");
        sb.append(this.im).append(")");
        return sb.toString();
    }

}
