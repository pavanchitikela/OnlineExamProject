package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.ExamLevel;

@Service
public interface LevelService {
	List<ExamLevel> findlevelsService();
    void modifyExamLevelByLevel_IdService(ExamLevel el);
    ExamLevel getLevelByLevelIdService(int LevelId);
}
