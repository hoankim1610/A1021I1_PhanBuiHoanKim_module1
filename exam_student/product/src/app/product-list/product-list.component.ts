import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from "../service/product-service.service";
import {MatDialog} from "@angular/material/dialog";
import {ProductDeleteComponent} from "../product-delete/product-delete.component";
import {Product} from "../data/Product";
import {CategoryServiceService} from "../service/category-service.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products : any = [];
  nameSearch: string;

  categories: any = [];
  nameTypeSearch: string;

  constructor(private productService: ProductServiceService,
              private categoryService: CategoryServiceService,
              private dialog : MatDialog) { }

  ngOnInit(): void {
    this.productService.getAll().subscribe(
      (res) => {
        this.products = res;
      })
  }

  openDialogDelete(id: number) {
    this.productService.findById(id).subscribe(
      (data) => {
        const dialogRef = this.dialog.open(ProductDeleteComponent, {
          width: "700px",
          data: {datal : data}
        })
        dialogRef.afterClosed().subscribe(res => {
          this.ngOnInit();
        })
      })
  }

  searchByName() {
    this.productService.findByName(this.nameSearch).subscribe((data) => {
      this.products = data;
    })
  }

  searchByType() {
    this.categoryService.findByType(this.nameSearch).subscribe((data) => {
      this.products = data;
    })
  }

}
