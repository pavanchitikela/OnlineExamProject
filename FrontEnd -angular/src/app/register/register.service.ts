import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ExamUser } from './ExamUser';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {


  constructor(private myHttp:HttpClient) { }
  addUserService(examuser: ExamUser)  {
    return this.myHttp.post("http://localhost:8080/addUser",examuser,{responseType:'text'});
     
  }

}
