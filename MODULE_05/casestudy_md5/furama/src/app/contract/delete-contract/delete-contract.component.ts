import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CustomerService} from "../../service/customer.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router} from "@angular/router";
import {DeleteFacilitiesComponent} from "../../facility/delete-facilities/delete-facilities.component";
import {ContractService} from "../../service/contract.service";

@Component({
  selector: 'app-delete-contract',
  templateUrl: './delete-contract.component.html',
  styleUrls: ['./delete-contract.component.css']
})
export class DeleteContractComponent implements OnInit {

  nameD: any;
  idD: any;

  constructor(public dialogRef: MatDialogRef<DeleteContractComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              private contractService: ContractService,
              private snackBar: MatSnackBar,
              private router: Router) {
  }

  ngOnInit() {
    console.log(this.data.datal)
    this.nameD = this.data.datal.name;
    this.idD = this.data.datal.id;
  }

  delete() {
    this.contractService.delete(this.idD).subscribe(
      (data) => {
        console.log('Success');
        this.dialogRef.close();
        this.router.navigateByUrl("/contracts/contract-list")
        this.snackBar.open("Successfully!", "ok");
      });
  }
}
