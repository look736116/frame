package com.my.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.TradeDao;
import com.my.momel.Trade;
import com.my.service.TradeService;

@Service(value="tradeService")
public class TradeServiceImpl implements TradeService {
	
	@Resource(name="tradeDao")
	TradeDao tradeDao ;

	@Override
	public List<Trade> getAllTrades() {
		// TODO Auto-generated method stub
		return tradeDao.getAllTrades();
	}
	
	@Override
	public List<Trade> getTradesByCondition(String tradeServer, String tradeTime, String tradeMoney, int firstResult,
			int maxResults) {
		// TODO Auto-generated method stub
		return tradeDao.getTradesByCondition(tradeServer, tradeTime, tradeMoney, firstResult, maxResults);
	}

	@Override
	@Transactional
	public int saveTrade(Trade trade) {
		// TODO Auto-generated method stub
		return tradeDao.saveTrade(trade);
	}

	@Override
	public int getPagesNum(int maxResults) {
		// TODO Auto-generated method stub
		
		int recordsNum = tradeDao.getRocordsNum();
		if(recordsNum % maxResults == 0){
			return recordsNum / maxResults;
		}else{
			return recordsNum / maxResults + 1;
		}
	}

}
