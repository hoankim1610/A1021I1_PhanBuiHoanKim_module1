import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ICustomerAccount} from '../../model/account/icustomer-account';
import {Observable} from 'rxjs';

const API_URL = 'http://localhost:8080/api/account';
@Injectable({
  providedIn: 'root'
})
export class AccountServiceService {

  constructor(private http: HttpClient) { }

  createCustomerAccount(customerAccount: ICustomerAccount): Observable<ICustomerAccount> {
    return this.http.post<ICustomerAccount>(API_URL + '/create-Customer-Account', customerAccount); }
}
