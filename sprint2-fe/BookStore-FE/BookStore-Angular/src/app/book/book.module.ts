import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookRoutingModule } from './book-routing.module';
import { BookDetailComponent } from './book-detail/book-detail.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {BookListComponent} from './book-list/book-list.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [BookDetailComponent, BookListComponent],
  imports: [
    CommonModule,
    BookRoutingModule,
    NgxPaginationModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class BookModule { }
