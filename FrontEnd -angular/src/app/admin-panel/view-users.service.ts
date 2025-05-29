import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ExamResult } from './ExamResult';
import { ExamUser } from './ExamUser';

@Injectable({
  providedIn: 'root'
})
export class ViewUsersService {

  constructor(private myHttp:HttpClient) { }
  getAllUsersService():Observable<any>{
    return this.myHttp.get<ExamUser>("http://localhost:8080/getAllUsers");

  }
  getAllResultsService():Observable<any>{
    return this.myHttp.get<ExamResult>("http://localhost:8080/getAllResults");
  }
}
