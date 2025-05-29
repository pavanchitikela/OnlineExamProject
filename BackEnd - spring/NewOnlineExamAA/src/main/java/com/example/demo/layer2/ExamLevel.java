package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the EXAM_LEVEL database table.
 * 
 */
@Entity
@Table(name="EXAM_LEVEL")
@NamedQuery(name="ExamLevel.findAll", query="SELECT e FROM ExamLevel e")
public class ExamLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LEVEL_ID")
	private int levelId;

	@Column(name="CUTOFF_MARKS")
	private int cutoffMarks;

	private int duration;

	@Column(name="TOTAL_QS")
	private int totalQs;

	//bi-directional many-to-one association to ExamResult
	@OneToMany(mappedBy="examLevel")
	private List<ExamResult> examResults;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="examLevel")
	private List<Question> questions;

	public ExamLevel() {
	}

	public int getLevelId() {
		return this.levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public int getCutoffMarks() {
		return this.cutoffMarks;
	}

	public void setCutoffMarks(int cutoffMarks) {
		this.cutoffMarks = cutoffMarks;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getTotalQs() {
		return this.totalQs;
	}

	public void setTotalQs(int totalQs) {
		this.totalQs = totalQs;
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
		examResult.setExamLevel(this);

		return examResult;
	}

	public ExamResult removeExamResult(ExamResult examResult) {
		getExamResults().remove(examResult);
		examResult.setExamLevel(null);

		return examResult;
	}
    @JsonIgnore
	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setExamLevel(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setExamLevel(null);

		return question;
	}

}