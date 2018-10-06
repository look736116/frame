package com.my.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.RoleDao;
import com.my.momel.Role;


@Repository(value="roleDao")
public class RoleDaoImpl implements RoleDao {
	
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;	
	
	/**
	 * @author Look
	 * @param role
	 * @return Role
	 * 2018年9月20日 21:20:00
	 */
	@Transactional
	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(role);
		return role;
	}

	/**
	 * @author Look
	 * @return List<Role>
	 * 2018年9月20日 21:20:57
	 */	
	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		
		List<Role> roles = null;		
		Session session =sessionFactory.getCurrentSession();
		
		
		Criteria criteria = session.createCriteria(Role.class);		
		Criterion serverName = Restrictions.eq("roleServer", "一梦十年");
		Criterion userOrder = Restrictions.eq("roleOrder", 1);
		Criterion inCriterion = Restrictions.in("roleSect", new Object[]{"天山","星宿"});
		LogicalExpression andExp = Restrictions.and(serverName, userOrder);
		criteria.add(andExp);
		criteria.add(inCriterion);
		roles = criteria.list();
		
		
		return roles;
	}

/**
 * @author look
 * @param roleId
 */
	@Override
	public Role getRoleById(String roleId) {
		// TODO Auto-generated method stub
		Role role = null;
		Session session = sessionFactory.getCurrentSession();
		
		Role demoRole = new Role();
		demoRole.setRoleSect("星宿");
		
		Example example = Example.create(demoRole).excludeZeroes()		;
		Criteria criteria = session.createCriteria(Role.class);
		
		List<Role> roles =criteria.add(example).list();
		
		return roles.get(0);
	
	}

}
