package com.my.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public int getRecordsNumByCondition(String tradeServer, String tradeTime, String tradeMoney) {
		// TODO Auto-generated method stub
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
		
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
	
	@Override
	@Transactional
	public String callProcedure(){				
	
		String sql = "{Call PRO_TEST(?,?,?,?)}";
		Connection con = null;
		CallableStatement cs =null;		
		String flag = "0";
		int num = 0;
		
		try {
			con = SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
			cs = con.prepareCall(sql);
			cs.setInt(1, 1);
			cs.setString(2,"55");			
			cs.registerOutParameter(3, Types.VARCHAR);//注册输出参数
			cs.registerOutParameter(4, Types.INTEGER);//注册输出参数
			
			cs.execute();
			if (!cs.getMoreResults()) {//此行判断是否还有更多的结果集,如果没有,接下来会处理output返回参数了 
				flag = cs.getString(3);
				num = cs.getInt(4);
			}			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
		return flag + num;
		
		
		
	}
	

}
