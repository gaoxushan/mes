package com.hmmes.bean;


public class SysUser extends BaseBean {
	
	
	
	private Integer superAdmin;//��������Ա
	
	private String roleStr;//�û�Ȩ��, ��","����
	
	
	
		return this.roleStr;
	}
	public void setRoleStr(String roleStr) {
		this.roleStr = roleStr;
	}
	public Integer getId() {
	public Integer getSuperAdmin() {
		return this.superAdmin;
	}
	public void setSuperAdmin(Integer superAdmin) {
		this.superAdmin = superAdmin;
	}
}