package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.ExamLevel;

@Repository
public interface LevelRepository {
	List<ExamLevel> findlevels();
    void modifyExamLevelByLevel_Id(ExamLevel el);
    ExamLevel getLevelByLevelId(int LevelId);
}