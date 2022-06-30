package com.aspress.prospring2.ch03.autowiring;

public class Target {
	private Foo foo;
    private Foo foo2;
    private Bar bar;
    
    public Target() { System.out.println("Target()"); }
    
    public Target(Foo foo) {
        System.out.println("Target(Foo)");
        this.foo = foo;
    }
    
    public Target(Foo foo, Bar bar) {
        System.out.println("Target(Foo, Bar)");
        this.foo = foo;
        this.bar = bar;
    }

    public void setDependency(Bar bar) {
        System.out.println("Target.setDependency(Bar)");
        this.bar = bar;
    }
    
    public void setFoome(Foo foo) {
    	System.out.println("Target.setFoome(Foo)");
    	this.foo = foo;
    }
    
    public void setMe(Bar bar1) {
        System.out.println("Target.setMe(Bar1)");
        this.bar = bar1;
    }
    
    public void setYou(Bar bar) {
        System.out.println("Target.setYou(Bar)");
        this.bar = bar;
    }
    
    public void setHello() {
    	System.out.println("Target.setHello()");
    }
    
    public void hiFillMe(Bar bar) {
    	this.bar = bar;
    }
    

    public void setFoo(Foo foo) {
        System.out.println("Target.setFoo(Foo)");
        this.foo = foo;
    }

    public void setFoo2(Foo foo2) {
        System.out.println("Target.setFoo2(Foo)");
        this.foo2 = foo2;
    }

    public void setBar(Bar bar) {
        System.out.println("Target.setBar(Bar)");
        this.bar = bar;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Target");
        sb.append("{foo=").append(foo);
        sb.append(", foo2=").append(foo2);
        sb.append(", bar=").append(bar);
        sb.append('}');
        return sb.toString();
    }
    
    
}
