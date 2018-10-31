package com.my.dao;

import java.util.List;

import com.my.momel.Weight;

public interface WeightDao {
	
	//save weight info 
	public int saveWightInfo(Weight weight);
	
	//get all weight info
	public List<Weight> getAllWeightInfo();
	
	//get weight info by name
	public List<Weight> getWeightInfoByName(String recordName);

}
