import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IBook} from '../../model/book/ibook';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  readonly URI: string = 'http://localhost:8080/api/book';

  constructor(private httpClient: HttpClient) {
  }

  getAllBook(): Observable<IBook[]> {
    return this.httpClient.get<IBook[]>(this.URI + '/book-customer/no-login/book-list');
  }

  searchBook(categoryName: string, bookName: string): Observable<string[]> {
    // tslint:disable-next-line:max-line-length
    return this.httpClient.get<string[]>(this.URI + '/book-customer/no-login/book-search' + '?categoryName=' + categoryName + '&bookName=' + bookName);
  }
}
