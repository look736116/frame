package com.my.dao;

import java.util.List;

import com.my.momel.Trade;

public interface TradeDao {
	
	//get all trades info
	public List<Trade> getAllTrades();
	
	//get trades by page, by serverName,tradeTime and tradeMoney
	public List<Trade> getTradesByCondition(String tradeServer,String tradeTime,String tradeMoney,int firstResult,int maxResults);
	
	//add new trade info into DB
	public int saveTrade(Trade trade);	
	
	//get records num
	public int getRocordsNum();
	
	//get records num  by serverName,tradeTime and tradeMoney
	public int getRecordsNumByCondition(String tradeServer,String tradeTime,String tradeMoney);
	
	//test procedure
	public String callProcedure();

}
