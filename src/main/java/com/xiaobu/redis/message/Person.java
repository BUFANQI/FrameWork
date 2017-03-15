package com.xiaobu.redis.message;

import java.io.Serializable;
import java.math.BigDecimal;

public class Person implements Serializable {
    private static final long serialVersionUID = -2862585049955236662L;
	public String name="����";
	public int age=18;
	
	public Person(){}
	public Person(String name){
		this.name=name;
	}
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static void main(String[] args) {
		System.out.println(new BigDecimal("12.35").setScale(1, BigDecimal.ROUND_HALF_UP));
	}
}
