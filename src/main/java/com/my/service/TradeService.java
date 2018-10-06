package com.my.service;

import java.util.List;

import com.my.momel.Trade;

public interface TradeService {
		//get all trade info
		public List<Trade> getAllTrades();
		
		//get trades by page, by serverName,tradeTime and tradeMoney
		public List<Trade> getTradesByCondition(String tradeServer,String tradeTime,String tradeMoney,int firstResult,int maxResults);

		
		//add new trade info into DB
		public int saveTrade(Trade trade);
		
		//get pages num		
		public int getPagesNum(int maxResults);

}
