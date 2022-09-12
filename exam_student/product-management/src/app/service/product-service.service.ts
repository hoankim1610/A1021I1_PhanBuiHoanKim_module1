import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {IProduct} from "../model/IProduct";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  API_URL = "http://localhost:3000/products";

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(this.API_URL);
  }

  find(id: number): Observable<any> {
    return this.http.get(this.API_URL + id);
  }

  create(product: FormGroup) {
    return this.http.post<IProduct>(this.API_URL, product);
  }

  update(id: number, product: FormGroup) {
    return this.http.put<IProduct>(this.API_URL + '/' + id, product);;
  }

  delete(id: number): Observable<IProduct[]> {
    return this.http.delete<IProduct[]>(this.API_URL + '/' + id);
  }

  findById(id: number): Observable<IProduct[]> {
    return this.http.get<IProduct[]>(`${this.API_URL}/${id}`);
  }

  findByName(nameSearch: string) {
    return this.http.get(this.API_URL + '?name_like=' + nameSearch)
  }
}
