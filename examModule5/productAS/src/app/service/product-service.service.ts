import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../data/Product";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  // API_URL = "http://localhost:3000/product";

  readonly API_URL: string = "http://localhost:8080/api/product";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.API_URL);
  }

  getAllPage(page: number, size: number): Observable<Product[]> {
    return this.http.get<Product[]>(this.API_URL + '/' + page + '/' + size);
  }

  create(product: Product[]) {
    return this.http.post<Product[]>(this.API_URL, product);
  }

  findById(id: number): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.API_URL}/${id}`);
  }

  delete(id: number) {
    return this.http.delete(this.API_URL + '/' + id);
  }
}
