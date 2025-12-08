package com.java8;

import java.util.function.Function;
import java.util.function.Predicate;

public class Java8demo {

	public static void main(String[] args) {
	Predicate<Integer> isEven = x->x%2==0;
	Predicate<Integer> osOdd = x->x%2==1;
	
	System.out.println(isEven.test(5));
	
	Function<Integer,Integer> doubl= x->x*2;
	Function<Integer,Integer> trip= x->x*3;
	
	System.out.println(doubl.andThen(trip));
	}

	

}
