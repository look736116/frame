package com.my.momel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_role")
public class Role {
	
	@Id
	@Column(name="Role_Id")
	private String roleId;
	
	@Column(name="Role_Account")
	private String roleAccount;
	
	@Column(name="Role_Name")
	private String roleName;
	
	@Column(name="Role_Sect")
	private String roleSect;
	
	@Column(name="Role_Grade")
	private int roleGrade;
	
	@Column(name="Role_Server")
	private String roleServer;
	
	@Column(name="Role_Order")
	private int roleOrder;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleAccount() {
		return roleAccount;
	}

	public void setRoleAccount(String roleAccount) {
		this.roleAccount = roleAccount;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleSect() {
		return roleSect;
	}

	public void setRoleSect(String roleSect) {
		this.roleSect = roleSect;
	}

	public int getRoleGrade() {
		return roleGrade;
	}

	public void setRoleGrade(int roleGrade) {
		this.roleGrade = roleGrade;
	}

	public String getRoleServer() {
		return roleServer;
	}

	public void setRoleServer(String roleServer) {
		this.roleServer = roleServer;
	}	

	public int getRoleOrder() {
		return roleOrder;
	}

	public void setRoleOrder(int roleOrder) {
		this.roleOrder = roleOrder;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleAccount=" + roleAccount + ", roleName=" + roleName + ", roleSect="
				+ roleSect + ", roleGrade=" + roleGrade + ", roleServer=" + roleServer + ", roleOrder=" + roleOrder
				+ "]";
	}

}
