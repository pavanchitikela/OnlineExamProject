package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.List;


/**
 * The persistent class for the EXAM_USER database table.
 * 
 */
@Entity
@Table(name="EXAM_USER")
@NamedQuery(name="ExamUser.findAll", query="SELECT e FROM ExamUser e")
public class ExamUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private int userId;

	private String city;


	private String email;

	private long mobile;

	private String password;

	private String qual;

	@Column(name="RESET_PASSWORD_TOKEN")
	private String resetPasswordToken;

	@Column(name="STATE")
	private String state;

	private String username;

	private int yoc;

	//bi-directional many-to-one association to ExamResult
	@OneToMany(mappedBy="examUser")
	private List<ExamResult> examResults;

	//bi-directional many-to-one association to SessionInfo
	@OneToMany(mappedBy="examUser")
	private List<SessionInfo> sessionInfos;

	//bi-directional many-to-one association to UserOption
	@OneToMany(mappedBy="examUser")
	private List<UserOption> userOptions;

	public ExamUser() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return this.mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQual() {
		return this.qual;
	}

	public void setQual(String qual) {
		this.qual = qual;
	}

	public String getResetPasswordToken() {
		return this.resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getYoc() {
		return this.yoc;
	}

	public void setYoc(int yoc) {
		this.yoc = yoc;
	}
    @JsonIgnore
	public List<ExamResult> getExamResults() {
		return this.examResults;
	}

	public void setExamResults(List<ExamResult> examResults) {
		this.examResults = examResults;
	}

	public ExamResult addExamResult(ExamResult examResult) {
		getExamResults().add(examResult);
		examResult.setExamUser(this);

		return examResult;
	}

	public ExamResult removeExamResult(ExamResult examResult) {
		getExamResults().remove(examResult);
		examResult.setExamUser(null);

		return examResult;
	}
    
	@JsonIgnore
	public List<SessionInfo> getSessionInfos() {
		return this.sessionInfos;
	}

	public void setSessionInfos(List<SessionInfo> sessionInfos) {
		this.sessionInfos = sessionInfos;
	}

	public SessionInfo addSessionInfo(SessionInfo sessionInfo) {
		getSessionInfos().add(sessionInfo);
		sessionInfo.setExamUser(this);

		return sessionInfo;
	}

	public SessionInfo removeSessionInfo(SessionInfo sessionInfo) {
		getSessionInfos().remove(sessionInfo);
		sessionInfo.setExamUser(null);

		return sessionInfo;
	}
    
	@JsonIgnore
	public List<UserOption> getUserOptions() {
		return this.userOptions;
	}

	public void setUserOptions(List<UserOption> userOptions) {
		this.userOptions = userOptions;
	}

	public UserOption addUserOption(UserOption userOption) {
		getUserOptions().add(userOption);
		userOption.setExamUser(this);

		return userOption;
	}

	public UserOption removeUserOption(UserOption userOption) {
		getUserOptions().remove(userOption);
		userOption.setExamUser(null);

		return userOption;
	}

}