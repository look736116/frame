
package com.my.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.momel.Role;
import com.my.service.RoleService;

@Controller
@RequestMapping(value = "/user")
public class UserController {	
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	private static Logger logger = LogManager.getLogger(UserController.class);
	
	@RequestMapping(value = "/test")
	public String recruitdemand(final HttpServletRequest request, final HttpServletResponse response) {
		Role role = new Role();
		role.setRoleId(UUID.randomUUID().toString().replaceAll("-", ""));
		role.setRoleAccount("a413978842");
		role.setRoleGrade(50);
		role.setRoleName("哈哈");	
		role.setRoleSect("慕容");
		role.setRoleOrder(1);
		role.setRoleServer("一梦十年");
		Role newRole = roleService.addRole(role);	
		logger.info(newRole.toString());
		logger.info(newRole.getRoleId());
		
		Role role2 = roleService.getRoleById("33");
		logger.info(role2.toString());
		
		List<Role> roles =roleService.getAllRoles();
		logger.info(roles.size());
		
		return "index";
	}
	
	@RequestMapping(value = "/test.do")
	public String doFilter(final HttpServletRequest request, final HttpServletResponse response) {
		System.err.println("=======");
		
		return "index";
	}
	
	

}
