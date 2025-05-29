import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ExamInfo } from '../new-exam/ExamInfo';
import { QuestionService } from './question.service';
import { Question} from './Question';
import { UserOptionService } from './user-option.service';
import { UserOptionDto } from './UserOptionDto';
import { ExamUser } from '../login/ExamUser';
import { ResultDTO } from './ResultDTO';
import { NavBarComponent } from '../nav-bar/nav-bar.component';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {
  

  constructor(private questionServ: QuestionService,private router: Router,private userOptServ:UserOptionService,private navBarComp:NavBarComponent){ 
  
  }
  tempQuestion: Question = new Question();

  resDto: ResultDTO=new ResultDTO();
  str:any| undefined; 
  isLastQuestion: boolean=false;
  isLoggedIn!: boolean;
  isExamStarted!: boolean;
  
  ngOnInit(): void {   // To display First Question
  

  this.str=sessionStorage.getItem("currentUserDetails");
  let examUser:ExamUser = JSON.parse(this.str);
  this.str=sessionStorage.getItem("loginInfo");
  this.isLoggedIn=JSON.parse(this.str);

  if(this.isLoggedIn==true){
  // this.isExamStarted=true;
  // sessionStorage.setItem("ExamStartDetails",JSON.stringify(this.isExamStarted));
  this.navBarComp.examStartFun();
  this.str = sessionStorage.getItem("examDetails");
  let myExamInfo:ExamInfo = JSON.parse(this.str);
 
  this.resDto.userId=examUser.userId;
  this.resDto.examId=myExamInfo.examId;
  this.resDto.levelId=myExamInfo.levelId;
  this.resDto.marks=0;
  this.resDto.crctAns=0;
  this.resDto.incrctAns=0;
  this.resDto.percentage=0;
  sessionStorage.setItem("ResultInfo",JSON.stringify(this.resDto));
  
  if(myExamInfo.levelId<3){
      myExamInfo.levelId++;
      myExamInfo.qsNo++;
      sessionStorage.setItem("examDetails",JSON.stringify(myExamInfo));
     // alert("Exam Id :"+myExamInfo.examId);
     // alert("Level Id :"+myExamInfo.levelId);
     // alert("Question No :"+myExamInfo.qsNo);
 
     this.questionServ.findQuestionsByExamIdLevelIdService(myExamInfo.examId,myExamInfo.levelId,myExamInfo.qsNo).subscribe((data)=>{
     if(data!=null){
        this.tempQuestion=data;
        // alert(this.tempQuestion);
        // alert("Question Id:"+this.tempQuestion.questionId);
       sessionStorage.setItem("QuestionDetails",JSON.stringify(this.tempQuestion));
      }
     else{
        alert("unable to fetch data");
      }
    })
  }

  else{
    alert("You completed all levels...")
  this.router.navigate(["Home"]);
  }
}
}


str1:any| undefined; 
optStr:any| undefined; 
retest:boolean=false;
displayNextQuestion(){   // Move to Next Question & Answer Check.... 
 if(
   (<HTMLInputElement>document.getElementById("opt1")).checked==false &&
   (<HTMLInputElement>document.getElementById("opt2")).checked==false &&
   (<HTMLInputElement>document.getElementById("opt3")).checked==false &&
   (<HTMLInputElement>document.getElementById("opt4")).checked==false )
   {
     alert("please select any one option");
   }
 else{ 
  (<HTMLInputElement>document.getElementById("opt1")).checked=false;
   (<HTMLInputElement>document.getElementById("opt2")).checked=false;
   (<HTMLInputElement>document.getElementById("opt3")).checked=false;
   (<HTMLInputElement>document.getElementById("opt4")).checked=false;
  this.str1=sessionStorage.getItem("examDetails");
  let myExamInfo:ExamInfo = JSON.parse(this.str1);
  this.quesStr=sessionStorage.getItem("QuestionDetails");
  let myQuestions:Question=JSON.parse(this.quesStr);
  //alert("Correct Option :"+myQuestions.crctOpt);
  // alert(myQuestions.qsNo);
  if(myQuestions.qsNo<10){
    myQuestions.qsNo++;
    sessionStorage.setItem("examDetails",JSON.stringify(myExamInfo));
    //alert(myExamInfo.qsNo);
    this.questionServ.findQuestionsByExamIdLevelIdService(myExamInfo.examId,myExamInfo.levelId,myQuestions.qsNo++).subscribe((data)=>{
    if(data!=null){
      this.tempQuestion=data;
   

      // alert(this.tempQuestion);
      // alert("Question Id:"+this.tempQuestion.questionId);
      sessionStorage.setItem("QuestionDetails",JSON.stringify(this.tempQuestion));
      //this.quesStr=sessionStorage.getItem("QuestionDetails");
      //let myQuestions:Question=JSON.parse(this.quesStr);

      let correctOption=myQuestions.crctOpt;
      this.resStr=sessionStorage.getItem("ResultInfo");
      let myResults:ResultDTO=JSON.parse(this.resStr);
      let optionSelected=sessionStorage.getItem("optionSelected");
      //alert("Option selected :"+optionSelected);
      // alert("Correct Option :"+correctOption);

      if(correctOption==optionSelected){
         myResults.crctAns++;
      }
      //alert("Correct Ans count :"+myResults.crctAns);
      sessionStorage.setItem("ResultInfo",JSON.stringify(myResults));
    }
     else{
      alert("unable to fetch data");
     }})
  }

else{

  this.str1=sessionStorage.getItem("examDetails");
  let myExamInfo:ExamInfo = JSON.parse(this.str1);
  myExamInfo.qsNo=0;
  sessionStorage.setItem("examDetails",JSON.stringify(myExamInfo));
   
  alert("You completed all questions in a level...");

  this.str=sessionStorage.getItem("currentUserDetails");
  let examUser:ExamUser = JSON.parse(this.str);
  this.resStr=sessionStorage.getItem("ResultInfo");
  let myResults:ResultDTO=JSON.parse(this.resStr);
  myResults.marks=myResults.crctAns;
  myResults.incrctAns=10-myResults.crctAns;
  myResults.percentage=myResults.marks*10;
  if(myResults.marks>=6){
     myResults.status="pass";
  }
  else{
    myResults.status="fail";
    
  }
   myResults.userId=examUser.userId;
   myResults.examId=myExamInfo.examId;
   myResults.levelId=myExamInfo.levelId;
   //alert("...Correct Ans "+myResults.crctAns+".......Incorrect Ans :"+myResults.incrctAns+"....Marks Obtained : "+myResults.marks+"...Percentage :"+myResults.percentage+" .. Status : "+myResults.status);
   sessionStorage.setItem("ResultInfo",JSON.stringify(myResults));
   this.router.navigate(["report"]);
}
 }
}



  optionSelected!: string;
  userOptionDto:UserOptionDto=new UserOptionDto();
  str3:any| undefined; 
  str4:any| undefined; 
  quesStr: any| undefined; 
  resStr: any| undefined;

  radioChangeHandler(event: any){  // Radio button click function() for option Update 
    
    let optionSelected=event.target.value;
    sessionStorage.setItem("optionSelected",optionSelected);
    

    this.str3=sessionStorage.getItem("QuestionDetails");
    let quesInfo: Question = JSON.parse(this.str3);
     
    this.str4=sessionStorage.getItem("currentUserDetails");
    let userInfo:ExamUser = JSON.parse(this.str4);
     
    this.userOptionDto.userId=userInfo.userId;
    this.userOptionDto.questionId=quesInfo.questionId;
    this.userOptionDto.usOption=optionSelected;
     
    //alert("UserId :"+this.userOptionDto.userId);
    //alert("Question Id :"+this.userOptionDto.questionId);
    //alert("User Option :"+this.userOptionDto.usOption);
    this.userOptServ.updateOrAddOptionService(this.userOptionDto).subscribe((data)=>{
      if(data!=null){
        console.log(data);
        //alert("Updating or adding is successful");

      }},
      (err)=>{
        alert("some thing went wrong");
       console.log(err);
     }
    
    )
  }
}

