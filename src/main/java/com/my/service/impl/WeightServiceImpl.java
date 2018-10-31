package com.my.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.dao.WeightDao;
import com.my.momel.Weight;
import com.my.service.WeightService;

@Service(value="weightService")
public class WeightServiceImpl implements WeightService {
	
	@Resource(name="weightDao")	
	WeightDao weightDao;

	@Override
	public int saveWightInfo(Weight weight) {
		// TODO Auto-generated method stub
		return weightDao.saveWightInfo(weight);
	}

	@Override
	public List<Weight> getAllWeightInfo() {
		// TODO Auto-generated method stub
		return weightDao.getAllWeightInfo();
	}

	@Override
	public List<Weight> getWeightInfoByName(String recordName) {
		// TODO Auto-generated method stub
		return weightDao.getWeightInfoByName(recordName);
	}

}
