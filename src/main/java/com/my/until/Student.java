package com.my.until;

import java.io.Serializable;

public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8637548056456110901L;
	
	String name;

	public Student(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
	

}
