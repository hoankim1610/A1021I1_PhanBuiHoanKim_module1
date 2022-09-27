import {Component, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {DeleteComponent} from "../delete/delete.component";
import {StudentService} from "../service/student.service";
import {InstructorService} from "../service/instructor.service";
import {Instructor} from "../data/Instructor";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  p: number = 1;

  students: any = [];

  instructor: Instructor[] = [];

  constructor(private studentService: StudentService,
              private instructorService: InstructorService,
              private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.studentService.getAll().subscribe(
      (res) => {
        this.students = res;
      })
  }

  openDialogDelete(id: number) {
    this.studentService.findById(id).subscribe(
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
