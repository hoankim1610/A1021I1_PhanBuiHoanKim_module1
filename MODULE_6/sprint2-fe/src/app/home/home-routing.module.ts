import {RouterModule, Routes} from "@angular/router";
import {BookListComponent} from "./book-list/book-list.component";
import {BookDetailComponent} from "./book-detail/book-detail.component";
import {BookSearchComponent} from "./book-search/book-search.component";
import {BookPromotionComponent} from "./book-promotion/book-promotion.component";
import {BookCategoryComponent} from "./book-category/book-category.component";
import {NgModule} from "@angular/core";

const routes: Routes = [
  {path: '', component: BookListComponent},
  {path: 'detail/:id', component: BookDetailComponent},
  {path: 'category/:id', component: BookCategoryComponent},
  {path: 'search/:searchBook', component: BookSearchComponent},
  {path: 'promotion', component: BookPromotionComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule { }
