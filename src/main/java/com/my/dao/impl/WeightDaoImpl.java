package com.my.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.WeightDao;
import com.my.momel.Weight;

@Repository(value="weightDao")
public class WeightDaoImpl implements WeightDao {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;	


	@Override
	@Transactional
	public int saveWightInfo(Weight weight) {
		// TODO Auto-generated method stub
		
		Session session =sessionFactory.getCurrentSession();		
		
		return Integer.parseInt(session.save(weight).toString());
	}

	@Override
	public List<Weight> getAllWeightInfo() {
		// TODO Auto-generated method stub
		List<Weight> weights = null;
		Session session =sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Weight.class);
		weights = criteria.list();
		
		return weights;
	}

	@Override
	public List<Weight> getWeightInfoByName(String recordName) {
		// TODO Auto-generated method stub
		List<Weight> weights = null;
		Session session =sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Weight.class);
		criteria.add(Restrictions.eq("recordName", recordName));
		weights = criteria.list();		
		return weights;
	}

}
