package com.my.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		
		String sql = "SELECT * FROM tbl_role ";
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		roles = query.list();		
		return roles;
	}

/**
 * @author look
 * @param roleId
 * @return Role
 * 2018年9月21日 10:26:45
 */
	@Override
	public Role getRoleById(String roleId) {
		// TODO Auto-generated method stub
		Role role = null;
		role = (Role)sessionFactory.getCurrentSession().load(Role.class, "33");
		return role;
	}

}
