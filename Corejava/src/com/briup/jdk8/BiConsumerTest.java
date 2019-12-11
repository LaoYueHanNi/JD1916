package com.briup.jdk8;

import java.util.function.BiConsumer;

public class BiConsumerTest {
	public static void main(String[] args) {
		BiConsumer<String, Integer> bc = 
				(name,age)->{
					User s = new User(name,age);
					System.out.println(s);
				};
		
		bc.accept("tom", 21);
		
		BiConsumer<String, Integer> after = 
				(name,age)->{
					User s = new User(name,age);
					System.out.println("ÐÞ¸ÄageÖµ");
					s.setAge(age+1);
					System.out.println(s);
				};
		BiConsumer<String, Integer> bc2 = 
				bc.andThen(after);
		bc2.accept("kevin", 20);
	}
}
