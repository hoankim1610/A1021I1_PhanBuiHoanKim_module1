import { Component, OnInit } from '@angular/core';
import {Product} from "../data/Product";
import {Category} from "../data/Category";
import {ProductServiceService} from "../service/product-service.service";
import {CategoryServiceService} from "../service/category-service.service";
import {MatDialog} from "@angular/material/dialog";
import {DeleteComponent} from "../delete/delete.component";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  products: Product[] = [];

  category: Category[] = [];

  constructor(private productService: ProductServiceService,
              private categoryService: CategoryServiceService,
              private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.productService.getAll().subscribe(
      (res) => {
        this.products = res;
      })
  }

  openDialogDelete(id: number) {
    this.productService.findById(id).subscribe(
      (data) => {
        const dialogRef = this.dialog.open(DeleteComponent, {
          width: "700px",
          data: {datal: data}
        })
        dialogRef.afterClosed().subscribe(res => {
          this.ngOnInit();
        })
      })
  }

}
