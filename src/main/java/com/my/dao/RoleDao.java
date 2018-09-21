package com.my.dao;

import java.util.List;

import com.my.momel.Role;

public interface RoleDao {
	//add role
	public Role addRole(Role role);
	
	//get all roles
	public List<Role> getAllRoles();
	
	//get role by role id
	public Role getRoleById(String roleId);
	
}
