package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.ExamLevel;
import com.example.demo.layer3.LevelRepositoryImpl;

@Service
public class LevelServiceImpl implements LevelService {

	@Autowired
	LevelRepositoryImpl levelRepo;
	
	@Override
	public List<ExamLevel> findlevelsService() {
		List<ExamLevel> levelList=levelRepo.findlevels();
		return levelList;
	}

	@Override
	public void modifyExamLevelByLevel_IdService(ExamLevel el) {
		levelRepo.modifyExamLevelByLevel_Id(el);
		
	}

	@Override
	public ExamLevel getLevelByLevelIdService(int LevelId) {
		ExamLevel el = levelRepo.getLevelByLevelId(LevelId);
		return el;
	}

}