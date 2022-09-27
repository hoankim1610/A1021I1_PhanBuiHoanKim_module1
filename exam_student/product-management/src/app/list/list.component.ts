import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from "../service/product-service.service";
import {MatDialog} from "@angular/material/dialog";
import {DeleteComponent} from "../delete/delete.component";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  p : number = 1;

  products: any = [];
  nameSearch: any;

  term: string;

  constructor(private productService: ProductServiceService,
              private dialog : MatDialog) {
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

}
