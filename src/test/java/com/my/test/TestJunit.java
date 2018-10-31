package com.my.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.TradeDao;
import com.my.dao.WeightDao;
import com.my.momel.Trade;
import com.my.momel.Weight;
import com.my.service.TradeService;

@RunWith(SpringJUnit4ClassRunner.class)//让测试运行于Spring环境
@ContextConfiguration({"classpath*:config/beans.xml","classpath*:/spring-mvc.xml"}) //引入Spring配置   
public class TestJunit {
	
	@Resource
	private TradeService tradeService;
	
	@Resource(name="tradeDao")
	TradeDao tradeDao ;
	
	@Resource(name = "weightDao")
	WeightDao weightDao;
	@Ignore
	@Test
	@Transactional
	public void testPagesNum() {
		Assert.assertEquals("Pages num is not 2!", tradeService.getPagesNum(10), 2);
	}
	
	@Ignore
	@Test
	@Transactional
	public  void testJson() {		
		Map<String, Object> results= new  HashMap<String, Object>();		
		
		List<Trade>  trades = this.tradeService.getAllTrades();
		
		for (Trade trade : trades) {
			results.put(String.valueOf(trade.getTradeId()), trade);
			
		}
		
		JSONObject jsonObject = new JSONObject(results);
		JSONArray	jsonArray = new JSONArray(trades);
		System.out.println(jsonObject.toString());
		System.out.println(jsonArray.toString());
	}
	@Ignore
	@Test
	@Transactional
	public void testProcedure(){
		
		System.out.println(tradeDao.callProcedure());
		
	}
	
	

}
