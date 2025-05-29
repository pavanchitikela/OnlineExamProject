import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ExamUser } from '../register/ExamUser';

@Injectable({
  providedIn: 'root'
})
export class LoginCheckService {

  constructor(private myHttp:HttpClient) { }

  userValdationService(loginDetails:ExamUser):Observable<any>{

    return this.myHttp.post("http://localhost:8080/login",loginDetails);
  
  }
}
