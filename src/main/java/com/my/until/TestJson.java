package com.my.until;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jsonStr = "{'name':'Jack','sex':'boy','age':'12'}";
		JSONObject jb = new JSONObject(jsonStr);
		System.out.println(jb);
		String jsonArr = "[{'name':'Jack'},{'name':'Joe'},{'name':'Lucy'}]";
		JSONArray jsonArray = new JSONArray(jsonArr);
		System.out.println(jsonArray.toString());
		
		
	}

}
