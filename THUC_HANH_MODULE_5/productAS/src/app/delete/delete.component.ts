import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ProductServiceService} from "../service/product-service.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  nameD: any;
  idD: any;

  constructor(public dialogRef: MatDialogRef<DeleteComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              private productServiceService: ProductServiceService,
              private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    console.log(this.data.datal)
    this.nameD = this.data.datal.name;
    this.idD = this.data.datal.id;
  }

  delete() {
    this.productServiceService.delete(this.idD).subscribe(
      (data) => {
        console.log('Success');
        this.dialogRef.close();
        this.snackBar.open("Delete Successfully!", "ok");
      });
  }

}
