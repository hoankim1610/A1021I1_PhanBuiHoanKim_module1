import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BookDetailComponent} from './book-detail/book-detail.component';
import {BookListComponent} from './book-list/book-list.component';


const routes: Routes = [
  {path: 'book', component: BookListComponent},
  {path: 'detail/:id', component: BookDetailComponent},
  // {path: 'category/:id', component: BookListCategoryComponent},
  // {path: 'search/:searchKey', component: BookSearchComponent},
  // {path: 'promotions', component: BookPromotionListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule { }
