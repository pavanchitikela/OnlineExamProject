package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the SESSION_INFO database table.
 * 
 */
@Entity
@Table(name="SESSION_INFO")
@NamedQuery(name="SessionInfo.findAll", query="SELECT s FROM SessionInfo s")
public class SessionInfo implements Serializable {   //Unused..can be used to store session details..
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="SESSION_ID")
	private int sessionId;

	@Column(name="LOGIN_TIME")
	private String loginTime;

	@Column(name="LOGOUT_TIME")
	private String logoutTime;

	//bi-directional many-to-one association to ExamUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private ExamUser examUser;

	public SessionInfo() {
	}

	public int getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLogoutTime() {
		return this.logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
    
	@JsonIgnore
	public ExamUser getExamUser() {
		return this.examUser;
	}

	public void setExamUser(ExamUser examUser) {
		this.examUser = examUser;
	}

}