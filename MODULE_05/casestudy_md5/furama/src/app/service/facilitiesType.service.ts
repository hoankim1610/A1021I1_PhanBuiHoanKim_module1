import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Facilities} from "../data/facilities";
import {FacilitiesType} from "../data/facilititiesType";

@Injectable({
  providedIn: 'root'
})
export class FacilitiesTypeService {
  API_URL_Type = "http://localhost:3000/serviceType";

  constructor(private http_Type: HttpClient) { }

  getAllType() {
    return this.http_Type.get(this.API_URL_Type);
  }

  findByType(nameSearch: string) {
    return this.http_Type.get(this.API_URL_Type + '?name_like=' + nameSearch )
  }
}
