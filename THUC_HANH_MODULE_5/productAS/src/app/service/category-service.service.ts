import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../data/Category";

@Injectable({
  providedIn: 'root'
})
export class CategoryServiceService {

  // API_URL_Type = "http://localhost:3000/category";
  readonly API_URL_Type: string = "http://localhost:8080/category";

  constructor(private http_Type: HttpClient) { }

  getAllType() : Observable<Category[]>  {
    return this.http_Type.get<Category[]>(this.API_URL_Type);
  }
}
