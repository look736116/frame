package com.my.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.my.dao.TradeDao;
import com.my.momel.Trade;

@Repository(value="tradeDao")
public class TradeDaoImpl implements TradeDao {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;	

	@Override
	public List<Trade> getAllTrades() {
		// TODO Auto-generated method stub
		
		List<Trade> trades = null;
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria =session.createCriteria(Trade.class);
		criteria.addOrder(Order.asc("tradeTime"));
		trades =criteria.list();
		
		return trades;
	}
	
	@Override
	public List<Trade> getTradesByCondition(String tradeServer, String tradeTime,
			String tradeMoney,int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		List<Trade> trades = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria =session.createCriteria(Trade.class);
		if(!"全部区服".equals(tradeServer)){
			criteria.add(Restrictions.eq("tradeServer", tradeServer));
		}
		if(!"0".equals(tradeTime)){
			criteria.add(Restrictions.like("tradeTime", "%" + tradeTime + "%"));
		}
		
		if(!"0".equals(tradeMoney)){
			criteria.add(Restrictions.eq("tradeMoney",Integer.parseInt(tradeMoney)));
		}
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);
		trades = criteria.list();		
		return trades;
	}
	
	

	@Override
	public int saveTrade(Trade trade) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();		
		return Integer.parseInt(session.save(trade).toString());
	}

	@Override
	public int getRocordsNum() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria  =session.createCriteria(Trade.class);
		criteria.setProjection(Projections.rowCount());
		
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
	

}
