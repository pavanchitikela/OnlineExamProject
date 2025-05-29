import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from './Question';


@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private myHttp:HttpClient) { }


findQuestionsByExamIdLevelIdService(ExamId: number,LevelId:number,qsNo:number):Observable<any>{
  return this.myHttp.get<Question>("http://localhost:8080/getQuestion/"+ExamId+"/"+LevelId+"/"+qsNo);
  }

  
}