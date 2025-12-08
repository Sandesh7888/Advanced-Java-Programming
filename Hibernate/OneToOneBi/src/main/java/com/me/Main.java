package com.me;

public class Main {

	public static void main(String[] args) {
		Cat c =new Cat();
		Dog d=new Dog();
		Animal a=new Animal() {

			@Override
			public void eat() {
				System.out.println("sa");
				
			}

			@Override
			public void sleep() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		a.eat();
		
		c.eat();
		d.eat();
		Animal.info();
		c.run();
		d.run();
		System.out.println(Animal.age);
		
		
		
		
	}

}
