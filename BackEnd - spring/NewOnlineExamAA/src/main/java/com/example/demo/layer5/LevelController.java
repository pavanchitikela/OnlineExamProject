package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.ExamLevel;
import com.example.demo.layer4.LevelService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LevelController {

	@Autowired
	LevelService levelServ;
	@GetMapping(path="/getLevel/{mylevelId}")
	@ResponseBody
	public ExamLevel getLevelbyLevelIDController(@PathVariable("mylevelId") int LevelId) {
		ExamLevel el=levelServ.getLevelByLevelIdService(LevelId);
		return el;
	}
	 @GetMapping(path="/getAllLevels")
	 @ResponseBody
     public List<ExamLevel> getAllLevels() {
	  List<ExamLevel> elList=levelServ.findlevelsService();	
	  return elList;
	}
	 @PutMapping(path="/modifyLevel")
	 @ResponseBody
	 void modifyExamLevelByLevel_IdService(@RequestBody ExamLevel el) {
		 levelServ.modifyExamLevelByLevel_IdService(el);
	 }
}