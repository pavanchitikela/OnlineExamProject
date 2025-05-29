package com.example.demo.layer5;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.layer2.ExamResult;
import com.example.demo.layer2.DTO.ExamResultDTO;
import com.example.demo.layer4.ExamResultService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ExamResultController {
	@Autowired
	ExamResultService examResultServ;
	
	 @PostMapping(path="/addResult")
		public void addResult(@RequestBody ExamResultDTO resultDto) {
		 examResultServ.addResultDtoService(resultDto);
		}
	
	  @GetMapping(path="/getAllResults")
		 @ResponseBody
	     public List<ExamResult> getAllResultsService() {
		  List<ExamResult> resultList=examResultServ.getAllResultsService();	
		  return resultList;
		}
	  
	 
	  @GetMapping(path="/getResultsByUserId/{userId}")
		@ResponseBody
		public List<ExamResult> getUserController(@PathVariable("userId") int userId){
			List<ExamResult> resultList=examResultServ.getResultsByUserIdService(userId);
			return resultList;
		}
	  
	  @GetMapping(path="/getResultByUserIdExamIdLevelId/{myUserId}/{myExamId}/{myLevelId}")   
		@ResponseBody
		public ExamResult getResultByUserIdExamIdLevelId(@PathVariable("myUserId") int UserId, @PathVariable("myExamId") int ExamId, @PathVariable("myLevelId") int LevelId) {
		  ExamResult examResult = examResultServ.getResultByUserIdExamIdLevelIdService(UserId,ExamId,LevelId);
			return examResult;
		
		}
}



