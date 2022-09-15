import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ServiceListComponent } from './facility/service-list/service-list.component';
import { CreateServiceComponent } from './facility/create-service/create-service.component';
import { EditServiceComponent } from './facility/edit-service/edit-service.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { CreateCustomerComponent } from './customer/create-customer/create-customer.component';
import { EditCustomerComponent } from './customer/edit-customer/edit-customer.component';
import { ContractListComponent } from './contract/contract-list/contract-list.component';
import { HomeComponent } from './home/home.component';
import {HttpClientModule} from '@angular/common/http';
import {MatDialogModule} from "@angular/material/dialog";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import { DeleteCustomerComponent } from './customer/delete-customer/delete-customer.component';
import { DeleteFacilitiesComponent } from './facility/delete-facilities/delete-facilities.component';
import { DetailServiceComponent } from './facility/detail-service/detail-service.component';
import { DeleteContractComponent } from './contract/delete-contract/delete-contract.component';
import { EditContractComponent } from './contract/edit-contract/edit-contract.component';
import { CreateContractComponent } from './contract/create-contract/create-contract.component';
// import {NgxPaginationModule} from "ngx-pagination";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ServiceListComponent,
    CreateServiceComponent,
    EditServiceComponent,
    CustomerListComponent,
    CreateCustomerComponent,
    EditCustomerComponent,
    ContractListComponent,
    HomeComponent,
    DeleteCustomerComponent,
    DeleteFacilitiesComponent,
    DetailServiceComponent,
    DeleteContractComponent,
    EditContractComponent,
    CreateContractComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatDialogModule,
    BrowserAnimationsModule,
    MatSnackBarModule,
    FormsModule
    // NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
