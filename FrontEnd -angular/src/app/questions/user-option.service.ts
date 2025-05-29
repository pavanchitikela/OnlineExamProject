import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserOptionDto } from './UserOptionDto';

@Injectable({
  providedIn: 'root'
})
export class UserOptionService {

  constructor(private myHttp:HttpClient) { }
  updateOrAddOptionService(userOptionDto:UserOptionDto){
  return this.myHttp.post("http://localhost:8080/updateOrAddOption",userOptionDto,{responseType:"text"});
}

}