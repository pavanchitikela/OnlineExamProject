package com.example.demo.layer5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.layer2.Question;
import com.example.demo.layer4.QuestionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class QuestionController {

	@Autowired
	QuestionService quesServ;
	
	@GetMapping(path="/getQuestion/{myExamId}/{myLevelId}/{myQsNo}")
	@ResponseBody
	public Question getQuestionController(@PathVariable("myExamId") int ExamId,@PathVariable("myLevelId") int LevelId,@PathVariable("myQsNo") int qsNo) {
		Question ques=quesServ.findQuestionsByExamIdandLevelIdService(ExamId, LevelId, qsNo);
		return ques;
	}
	@PostMapping(path="/addQuestion")
	public void addQuestion(@RequestBody Question qu) {
		quesServ.addQuestionService(qu);;
	}
	 @DeleteMapping(path="/removeQuestion/{myqsNo}")
	 @ResponseBody
	 void removeQuestion(@PathVariable("myqsNo") int QS_NO) {
		 quesServ.removeQuestionService(QS_NO);
	}
}
