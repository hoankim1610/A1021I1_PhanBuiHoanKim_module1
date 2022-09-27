import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Instructor} from "../data/Instructor";

@Injectable({
  providedIn: 'root'
})
export class InstructorService {

  API_URL_Type = "http://localhost:3000/instructor";

  constructor(private http_Type: HttpClient) { }

  getAllType() : Observable<Instructor[]>  {
    return this.http_Type.get<Instructor[]>(this.API_URL_Type);
  }
}
