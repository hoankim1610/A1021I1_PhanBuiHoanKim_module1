import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Todo} from "../data/todo";

@Injectable({
  providedIn: 'root'
})
export class TodoServiceService {
  private API_URL =  ' http://localhost:3000/todos';

  constructor(private http: HttpClient) {}
    getAll(): Observable<Todo[]> {
      return this.http.get<Todo[]>(this.API_URL);
    }

    saveToDo(contentNew: string): Observable<void> {
      const todo: Todo = {
      content: contentNew,
      complete: false
    };
    return this.http.post<void>(this.API_URL, todo);
  }

    findById(id: number): Observable<Todo> {
      return this.http.get<Todo>(this.API_URL + '/' + id);
    }

    updateTodo(id: number, todo: Todo): Observable<Todo> {
      return this.http.put<Todo>(`${this.API_URL}/${id}`, todo);
    }

    deleteTodo(id: number): Observable<Todo> {
      return this.http.delete<Todo>(`${this.API_URL}/${id}`);
    }
}
