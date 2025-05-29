package com.example.demo.layer3;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.layer2.ExamResult;


@Repository
public interface ResultRepository {
	void addResult(ExamResult result);
	 List<ExamResult> getAllResults();
	 ExamResult getResultByUserIdExamIdLevelId(int UserId,int ExamId,int LevelId);
	 List<ExamResult> getResultsByUserId(int userId);
	}