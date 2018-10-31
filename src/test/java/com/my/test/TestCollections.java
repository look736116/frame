package com.my.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lists = new ArrayList<String>();
		lists.add("00");
		lists.add("11");
		lists.add("22");
		lists.add("33");
		lists.add("44");
		lists.add("55");
		System.out.println(lists.size());
		
		lists.remove("55");
		System.out.println(lists.size());
		
		Iterator<String > iterator = lists.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}

	}

}
