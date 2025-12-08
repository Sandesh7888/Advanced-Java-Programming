package com.me;

public interface Animal {
	public static final int age=10;
	
	void eat();
	public abstract void sleep();
	
	static void info() {
		System.out.println("info..");
	}
	
	default void run() {
		this.eat();
		System.out.println("runniggg..");
	}
	
	
	

}
