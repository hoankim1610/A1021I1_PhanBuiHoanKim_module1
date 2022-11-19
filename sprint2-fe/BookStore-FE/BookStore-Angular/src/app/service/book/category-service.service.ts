import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {IBook} from '../../model/book/ibook';
import {HttpClient} from '@angular/common/http';
import {ICategory} from '../../model/book/icategory';

const URL_API = 'http://localhost:8080/api/category';
@Injectable({
  providedIn: 'root'
})
export class CategoryServiceService {

  constructor(private http: HttpClient) { }

  getCategoryById(id: number): Observable<ICategory> {
    return this.http.get<ICategory>(`${URL_API}/${id}`);
  }

  getAllCategory(): Observable<ICategory[]> {
    return this.http.get<ICategory[]>(URL_API);
  }
}
