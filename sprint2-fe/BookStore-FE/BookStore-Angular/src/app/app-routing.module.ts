import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home/home.component";
import {DetailCartComponent} from "./cart/cart-detail/detail-cart.component";


const routes: Routes = [
  {
    path: 'auth',
    loadChildren: () => import('./security/security.module').then(module => module.SecurityModule)
  },
  {
    path: '',
    loadChildren: () => import('./book/book.module').then(module => module.BookModule)
  },
  {
    path: 'cart', component: DetailCartComponent
    // loadChildren: () => import('./cart/cart.module').then(module => module.CartModule)
  },
  {
    path: 'home', component: HomeComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
