import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {Product} from "../data/Product";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  API_URL = "http://localhost:3000/products";

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(this.API_URL);
  }

  create(product: FormGroup) {
    return this.http.post<Product>(this.API_URL, product);
  }

  update(id: number, product: FormGroup) {
    return this.http.put<Product>(this.API_URL + '/' + id, product);;
  }

  delete(id: number): Observable<Product[]> {
    return this.http.delete<Product[]>(this.API_URL + '/' + id);
  }

  findById(id: number): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.API_URL}/${id}`);
  }

  findByName(nameSearch: string) {
    return this.http.get(this.API_URL + '?name_like=' + nameSearch)
  }
}
