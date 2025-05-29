package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the QUESTION database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QUESTION_ID")
	private int questionId;
	
	@Column(name="QS_NO")
	private int qsNo;

	@Column(name="CRCT_OPT")
	private String crctOpt;

	private String opta;

	private String optb;

	private String optc;

	private String optd;

	private String question;

	//bi-directional many-to-one association to Exam
	@ManyToOne
	@JoinColumn(name="EXAM_ID")
	private Exam exam;

	//bi-directional many-to-one association to ExamLevel
	@ManyToOne
	@JoinColumn(name="LEVEL_ID")
	private ExamLevel examLevel;

	//bi-directional many-to-one association to UserOption
	@OneToMany(mappedBy="question")
	private List<UserOption> userOptions;

	public Question() {
	}
    
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getQsNo() {
		return this.qsNo;
	}

	public void setQsNo(int qsNo) {
		this.qsNo = qsNo;
	}

	public String getCrctOpt() {
		return this.crctOpt;
	}

	public void setCrctOpt(String crctOpt) {
		this.crctOpt = crctOpt;
	}

	public String getOpta() {
		return this.opta;
	}

	public void setOpta(String opta) {
		this.opta = opta;
	}

	public String getOptb() {
		return this.optb;
	}

	public void setOptb(String optb) {
		this.optb = optb;
	}

	public String getOptc() {
		return this.optc;
	}

	public void setOptc(String optc) {
		this.optc = optc;
	}

	public String getOptd() {
		return this.optd;
	}

	public void setOptd(String optd) {
		this.optd = optd;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	public ExamLevel getExamLevel() {
		return this.examLevel;
	}

	public void setExamLevel(ExamLevel examLevel) {
		this.examLevel = examLevel;
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
		userOption.setQuestion(this);
		return userOption;
	}

	public UserOption removeUserOption(UserOption userOption) {
		getUserOptions().remove(userOption);
		userOption.setQuestion(null);

		return userOption;
	}

}