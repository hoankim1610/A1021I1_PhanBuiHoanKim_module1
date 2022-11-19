import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LibraryComponent} from "./book/library.component";
import {CartComponent} from "./cart/cart.component";
import {AccountComponent} from "./account/account.component";
import {LoginComponent} from "./login/login.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'book', component: LibraryComponent},
  {path: 'cart', component: CartComponent},
  // {path: 'about', component: AboutComponent},
  {path: 'account', component: AccountComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
