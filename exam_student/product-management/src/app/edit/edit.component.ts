import { Component, OnInit } from '@angular/core';
import {Product} from "../../../../product/src/app/data/Product";
import {ProductServiceService} from "../service/product-service.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  products : Product;

  constructor(private productService: ProductServiceService,
              private router: Router,
              private active: ActivatedRoute,
              private snackBar : MatSnackBar) {
  }

    productForm = new FormGroup({
      id: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required, Validators.maxLength(10), Validators.pattern("^[a-zA-Z ]*")]), // chi duoc danh chu va co the co dau cach
      // ^[a-zA-Z ]*$ : khong chua dau cach
      price: new FormControl('', [Validators.required, Validators.min(100000), Validators.pattern("^[-+]?[0-9]*")]),
      status: new FormControl('', [Validators.required]),
      quantity: new FormControl('', [Validators.required, Validators.min(10)])
    });

  get name() {
    return this.productForm.get('name');
  }

  get price() {
    return this.productForm.get('price');
  }

  get quantity() {
    return this.productForm.get('quantity');
  }

  get status() {
    return this.productForm.get('status');
  }

  ngOnInit(): void {
    this.productService.findById(this.active.snapshot.params.id).subscribe(
      (data) => {
        this.productForm.setValue(data);
      })
    this.productService.getAll().subscribe((res) => {
      this.products = res;
    })
  }

  editNew() {
    this.productService.update(this.active.snapshot.params.id, this.productForm.value).subscribe(
      (data) => {
        this.router.navigateByUrl("");
        this.snackBar.open("Update succesfully!", "ok")
      });
  }

}
