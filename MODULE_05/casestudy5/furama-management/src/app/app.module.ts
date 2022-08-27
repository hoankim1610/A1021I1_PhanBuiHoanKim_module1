import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderFootComponent } from './header-foot/header-foot.component';
import { ServiceListComponent } from './service-list/service-list.component';
import { EditServiceComponent } from './edit-service/edit-service.component';
import { CreateServiceComponent } from './create-service/create-service.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CustomerListComponent } from './customer-list/customer-list.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderFootComponent,
    ServiceListComponent,
    EditServiceComponent,
    CreateServiceComponent,
    EditCustomerComponent,
    CreateCustomerComponent,
    CustomerListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
