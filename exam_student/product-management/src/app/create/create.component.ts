import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductServiceService} from "../service/product-service.service";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import validate = WebAssembly.validate;

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  productForm: FormGroup;

  constructor(private productService: ProductServiceService,
              private router: Router,
              private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.productForm = new FormGroup({
      id: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required, Validators.maxLength(10), Validators.pattern("^[a-zA-Z ]*")]), // chi duoc danh chu va co the co dau cach
      // ^[a-zA-Z ]*$ : khong chua dau cach
      price: new FormControl('', [Validators.required, Validators.min(100000), Validators.pattern("^[-+]?[0-9]*")]),
      status: new FormControl('', [Validators.required, Validators.email]),
      quantity: new FormControl('', [Validators.required, Validators.min(10)])
    });
  }

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

  add() {
    this.productService.create(this.productForm.value).subscribe(
      (res) => {
        this.router.navigateByUrl("");
        this.snackBar.open('Create successfully!', 'ok');
      }
    );
  }

}
