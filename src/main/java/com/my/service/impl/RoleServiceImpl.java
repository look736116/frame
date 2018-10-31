package com.my.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.RoleDao;
import com.my.dao.impl.RoleDaoImpl;
import com.my.momel.Role;
import com.my.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	@Resource(name ="roleDao")
	private RoleDao roleDao;	

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return roleDao.addRole(role);
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleDao.getAllRoles();
	}

	@Override
	public Role getRoleById(String roleId) {
		// TODO Auto-generated method stub
		return roleDao.getRoleById(roleId);
	}

}
