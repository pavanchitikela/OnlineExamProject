import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ExamInfo } from '../new-exam/ExamInfo';
import { UserInfo } from '../new-exam/UserInfo';
import { Question } from '../questions/Question';
import { ResultDTO } from '../questions/ResultDTO';
import { ReportService } from './report.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  constructor(private router: Router,private reportServ:ReportService) {  }

resultStatus=true;
qsDto:Question=new Question();

resultInfo:ResultDTO = new ResultDTO();
myExamInfo:ExamInfo = new ExamInfo();
myUserInfo:UserInfo = new UserInfo();
//:ExamInfo=new ExamInfo();
str:any| undefined; 
logoutButton:boolean=false;
nextLevelButton:boolean=true;

ngOnInit(): void {
  this.str=sessionStorage.getItem("examDetails");
  this.myExamInfo= JSON.parse(this.str);
  
  this.str=sessionStorage.getItem("currentUserDetails");
  this.myUserInfo= JSON.parse(this.str);

    this.str=sessionStorage.getItem("ResultInfo");
    this.resultInfo=JSON.parse(this.str);

    if(this.resultInfo.status=="fail"){
       this.logoutButton=true;
       this.nextLevelButton=false;
    }
   
      this.reportServ.addResultService(this.resultInfo).subscribe((data)=>
      {
       
        if(data!=null){
          console.log(data);
          alert(data);
          alert("results added successful");
        }},
        (err)=>{
          alert("some thing went wrong");
         console.log(err);
       }
      
      )
    
}

retestFun(){
 if(confirm("Do you want to take retest ??")==true){
  this.str=sessionStorage.getItem("examDetails");
  let myExamInfo:ExamInfo = JSON.parse(this.str);
  // alert(myExamInfo.levelId);
  myExamInfo.levelId--;
  sessionStorage.setItem("examDetails",JSON.stringify(myExamInfo));
  this.router.navigate(["questions"]);
 }
}
  
}

