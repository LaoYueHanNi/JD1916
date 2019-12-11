package com.briup.enums;

public class TrafficLightTest {
	public static void main(String[] args) {
		TrafficLight[] tf=TrafficLight.values();
		for(TrafficLight temp:tf) {
			System.out.println(temp.toString()+"µ∆"+temp.getTime()+"√Î÷Æ∫Û «"+temp.next()+"µ∆");
		}
	}
}
