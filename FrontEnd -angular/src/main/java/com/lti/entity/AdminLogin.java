package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADMIN_LOGIN database table.
 * 
 */
@Entity
@Table(name="ADMIN_LOGIN")
@NamedQuery(name="AdminLogin.findAll", query="SELECT a FROM AdminLogin a")
public class AdminLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String adminid;

	private String password;

	public AdminLogin() {
	}

	public String getAdminid() {
		return this.adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}