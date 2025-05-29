import { DialogElementsDetailsDialogComponent } from './../dialog-elements-details-dialog/dialog-elements-details-dialog.component';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Exam } from './Exam';
import { ExamService } from './exam.service';
import { ExamInfo } from './ExamInfo';
import {MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-new-exam',
  templateUrl: './new-exam.component.html',
  styleUrls: ['./new-exam.component.css']
})

export class NewExamComponent {
  openDialog() {
    this.dialog.open(DialogElementsDetailsDialogComponent);
  }


  title = "Card View Demo";
  
  tempExams: Array<Exam> =[];
  ngOnInit(): void {
    this.examServ.getAllExams().subscribe((data)=>{
  
      if(data!=null){
          this.tempExams=data;
      }
      else{
          alert("unable to fetch");
        }})

  }
  gridColumns = 4;
  constructor(private examServ:ExamService,private router:Router ,public dialog: MatDialog) { }
  

  toggleGridColumns() {
    this.gridColumns = this.gridColumns === 3 ? 4 : 3;
  }
 
  tempExam: Exam= new Exam();
  examInfo: ExamInfo=new ExamInfo();
  isLoggedIn: boolean=false;
  loginstr!: any;
  getExamByName(examName: string){
    //  alert(examName); 
    this.loginstr=sessionStorage.getItem("loginInfo");
    this.isLoggedIn=JSON.parse(this.loginstr);
    if(this.isLoggedIn==true){
       this.examServ.getExamByName(examName).subscribe((data)=>{
       if (data!=null) 
       {
         this.tempExam=data;
         let levelId=0;
         let qsNo=0;
         this.examInfo.examId=this.tempExam.examId;
         this.examInfo.levelId=levelId;
         this.examInfo.qsNo=qsNo;
         this.router.navigate(["instructions"]);
         sessionStorage.setItem("examDetails",JSON.stringify(this.examInfo)); }
       else{
         alert('unable to fetch');
       }
       })
    }
    else{
       alert("Please Login...");
       this.router.navigate(["login"]);
      }
 
   }
  
}
export class DialogElementsDetailsDialog {}