import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CustomerListComponent} from "./customer/customer-list/customer-list.component";
import {CreateCustomerComponent} from "./customer/create-customer/create-customer.component";
import {EditCustomerComponent} from "./customer/edit-customer/edit-customer.component";
import {DeleteCustomerComponent} from "./customer/delete-customer/delete-customer.component";
import {ServiceListComponent} from "./facility/service-list/service-list.component";
import {CreateServiceComponent} from "./facility/create-service/create-service.component";
import {EditServiceComponent} from "./facility/edit-service/edit-service.component";
import {ContractListComponent} from "./contract/contract-list/contract-list.component";
import {DeleteContractComponent} from "./contract/delete-contract/delete-contract.component";
import {CreateContractComponent} from "./contract/create-contract/create-contract.component";
import {EditContractComponent} from "./contract/edit-contract/edit-contract.component";


const routes: Routes = [
  {path: "customer/customer-list" , component: CustomerListComponent},
  {path: "customer/customer-create" , component: CreateCustomerComponent},
  {path: "customer/customer-edit/:id" , component: EditCustomerComponent},
  {path: "customer/customer-delete" , component: DeleteCustomerComponent},
  {path: "facilities/facility-create" , component: CreateServiceComponent},
  {path: "facilities/facility-list" , component: ServiceListComponent},
  {path: "facilities/facility-edit/:id" , component: EditServiceComponent},
  {path: "facilities/facility-delete" , component: ServiceListComponent},
  {path: "facilities/facility-detail/:id" , component: ServiceListComponent},
  {path: "contracts/contract-list" , component: ContractListComponent},
  {path: "contracts/contract-delete" , component: DeleteContractComponent},
  {path: "contracts/contract-create" , component: CreateContractComponent},
  {path: "contracts/contract-edit/:id" , component: EditContractComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
