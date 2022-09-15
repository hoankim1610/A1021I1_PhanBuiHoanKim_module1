import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Facilities} from "../data/facilities";

@Injectable({
  providedIn: 'root'
})
export class FacilitiesService {
  API_URL = "http://localhost:3000/facilities";

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(this.API_URL);
  }

  create(product: Facilities) {
    return this.http.post<Facilities>(this.API_URL, product);
  }

  findById(id: number): Observable<Facilities[]> {
    return this.http.get<Facilities[]>(`${this.API_URL}/${id}`);
  }

  delete(id: number) {
    return this.http.delete(this.API_URL + '/' + id);
  }

  update(id: number, product: Facilities) {
    return this.http.put(`${this.API_URL}/${id}`, product);;
  }

  findByName(nameSearch: string) {
    return this.http.get(this.API_URL + '?name_like=' + nameSearch )
  }
}
