import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../data/Category";

@Injectable({
  providedIn: 'root'
})
export class CategoryServiceService {

  API_URL_Type = "http://localhost:3000/category";

  constructor(private http_Type: HttpClient) { }

  getAllType() : Observable<Category[]>  {
    return this.http_Type.get<Category[]>(this.API_URL_Type);
  }

  findByType(nameSearch: string) {
    return this.http_Type.get(this.API_URL_Type + '?name_like=' + nameSearch )
  }
}
