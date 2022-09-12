import { Injectable } from '@angular/core';
import {StudentInfo} from "../StudentInfo/StudentInfo";
import {IStudent} from "../Student/IStudent";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<IStudent[]> {
    return this.http.get<IStudent[]>(API_URL);
  }

  save(student): Observable<IStudent> {
    return this.http.post<IStudent>(API_URL + '/students', student);
  }

  findById(id: number): Observable<IStudent> {
    return this.http.get<IStudent>(`${API_URL}/students/${id}`);
  }

  // update(id: number, student: IStudent): Observable<IStudent> {
  //   return this.http.put<IStudent>(`${API_URL}/students/${id}`, student);
  // }
  //
  // delete(id: number): Observable<IStudent> {
  //   return this.http.delete<IStudent>(`${API_URL}/students/${id}`);
  // }
}
