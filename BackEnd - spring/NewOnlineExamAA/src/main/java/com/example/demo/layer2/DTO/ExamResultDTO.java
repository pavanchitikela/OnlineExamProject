package com.example.demo.layer2.DTO;

import javax.persistence.Column;

public class ExamResultDTO {

	private int crctAns;
    private int incrctAns;
    private int marks;
    private int percentage;
    private String status;
	private int userId;
	private int examId;
	private int levelId;
	public int getCrctAns() {
		return crctAns;
	}
	public void setCrctAns(int crctAns) {
		this.crctAns = crctAns;
	}
	public int getIncrctAns() {
		return incrctAns;
	}
	public void setIncrctAns(int incrctAns) {
		this.incrctAns = incrctAns;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	

}
