package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.ExamResult;
import com.example.demo.layer2.DTO.ExamResultDTO;

@Service
public interface ExamResultService {

	 void addResultDtoService(ExamResultDTO resultDto);
	 List<ExamResult> getAllResultsService();
	 ExamResult getResultByUserIdExamIdLevelIdService(int UserId,int ExamId,int LevelId);
	 List<ExamResult> getResultsByUserIdService(int userId) ;
	}

