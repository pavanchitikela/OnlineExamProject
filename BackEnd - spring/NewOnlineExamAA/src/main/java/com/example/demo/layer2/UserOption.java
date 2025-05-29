package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;




/**
 * The persistent class for the USER_OPTION database table.
 * 
 */
@Entity
@Table(name="USER_OPTION")
@NamedQuery(name="UserOption.findAll", query="SELECT u FROM UserOption u")
public class UserOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="UO_ID")
	private int userOptionId;

	@Column(name="US_OPTION")
	private String usOption;

	//bi-directional many-to-one association to ExamUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private ExamUser examUser;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private Question question;

	public UserOption() {
	}

	public int getUserOptionId() {
		return this.userOptionId;
	}

	public void setUserOptionId(int userOptionId) {
		this.userOptionId = userOptionId;
	}

	public String getUsOption() {
		return this.usOption;
	}

	public void setUsOption(String usOption) {
		this.usOption = usOption;
	}
	
	public ExamUser getExamUser() {
		return this.examUser;
	}

	public void setExamUser(ExamUser examUser) {
		this.examUser = examUser;
	}
	
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}