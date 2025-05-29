import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ResultDTO } from '../questions/ResultDTO';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private myHttp:HttpClient) { }
  addResultService(resultDto:ResultDTO)  {
    return this.myHttp.post("http://localhost:8080/addResult",resultDto);
     
  }

}
