import { Component, OnInit } from '@angular/core';
import {FacilitiesService} from "../../service/facilities.service";
import {FacilitiesType} from "../../data/facilititiesType";
import {MatDialog} from "@angular/material/dialog";
import {FacilitiesTypeService} from "../../service/facilitiesType.service";
import {DeleteFacilitiesComponent} from "../delete-facilities/delete-facilities.component";

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {

  facilities: any = [];
  nameSearch: string;

  // facilitiesType: any = [];
  // nameTypeSearch: string;

  constructor(private facilitiesService: FacilitiesService,
              private facilitiesTypeService: FacilitiesTypeService,
              private dialog : MatDialog) { }

  ngOnInit(): void {
    this.facilitiesService.getAll().subscribe(
      (res) => {
        this.facilities = res;
      })
  }

  openDialogDelete(id: number) {
    this.facilitiesService.findById(id).subscribe(
      (data) => {
        const dialogRef = this.dialog.open(DeleteFacilitiesComponent, {
          width: "700px",
          data: {datal : data}
        })
        dialogRef.afterClosed().subscribe(res => {
          this.ngOnInit();
        })
      })
  }

  searchByName() {
    this.facilitiesService.findByName(this.nameSearch).subscribe((data) => {
      this.facilities = data;
    })
  }

}
