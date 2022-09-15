import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Contract} from "../data/contract";

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  API_URL = "http://localhost:3000/contracts";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Contract[]> {
    return this.http.get<Contract[]>(this.API_URL);
  }

  create(product: Contract) {
    return this.http.post<Contract>(this.API_URL, product);
  }

  findById(id: number): Observable<Contract[]> {
    return this.http.get<Contract[]>(`${this.API_URL}/${id}`);
  }

  delete(id: number) {
    return this.http.delete(this.API_URL + '/' + id);
  }

  update(id: number, product: Contract) {
    return this.http.put(`${this.API_URL}/${id}`, product);;
  }

  findByName(nameSearch: string) {
    return this.http.get(this.API_URL + '?name_like=' + nameSearch )
  }
}
