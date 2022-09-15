import { Injectable } from '@angular/core';
import {Customer} from "../data/customer";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  API_URL = "http://localhost:3000/customer";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.API_URL);
  }

  create(product: Customer) {
    return this.http.post<Customer>(this.API_URL, product);
  }

  findById(id: number): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.API_URL}/${id}`);
  }

  delete(id: number) {
    return this.http.delete(this.API_URL + '/' + id);
  }

  update(id: number, product: Customer) {
    return this.http.put(`${this.API_URL}/${id}`, product);;
  }

  findByName(nameSearch: string) {
    return this.http.get(this.API_URL + '?name_like=' + nameSearch )
  }
}
