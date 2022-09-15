import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../data/Product";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  API_URL = "http://localhost:3000/products";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.API_URL);
  }

  create(product: Product) {
    return this.http.post<Product>(this.API_URL, product);
  }

  findById(id: number): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.API_URL}/${id}`);
  }

  delete(id: number) {
    return this.http.delete(this.API_URL + '/' + id);
  }

  update(id: number, product: Product) {
    return this.http.put(`${this.API_URL}/${id}`, product);;
  }

  findByName(nameSearch: string) {
    return this.http.get(this.API_URL + '?name_like=' + nameSearch )
  }
}
