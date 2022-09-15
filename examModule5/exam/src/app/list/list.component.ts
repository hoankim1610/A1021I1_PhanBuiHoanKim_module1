import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from "../service/product-service.service";
import {CategoryServiceService} from "../service/category-service.service";
import {DeleteComponent} from "../delete/delete.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  p : number = 1;

  products: any = [];
  nameSearch: string;

  categories: any = [];
  nameTypeSearch: string;

  constructor(private productService: ProductServiceService,
              private categoryService: CategoryServiceService,
              private dialog: MatDialog) { }

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
      this.categories = data;
    })
  }

}
