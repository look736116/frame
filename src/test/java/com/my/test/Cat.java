package com.my.test;

import org.hibernate.stat.internal.SessionStatisticsImpl;

public class Cat {
	private static Cat cat;

	private Cat() {		
	}
	
	public static Cat getCat(){
		if(cat ==null){
			cat = new Cat();
		}
		return cat;
	}
	

}
