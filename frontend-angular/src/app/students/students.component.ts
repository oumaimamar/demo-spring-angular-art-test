import { Component, OnInit, ViewChild} from '@angular/core';
import {StudentsService} from "../services/students.service";
import {Student} from "../model/students.model";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {Router} from "@angular/router";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrl: './students.component.css'

})
export class StudentsComponent implements OnInit {
   students!: Array<Student>;
   displayedColumns:string[]  = ['id','firstName','lastName','code','programId','payments' ];
   studentsDataSource!: MatTableDataSource<Student>;


  @ViewChild(MatPaginator) paginator! : MatPaginator;
  @ViewChild(MatSort) sort! : MatSort;
  constructor(private studentsService: StudentsService,private router : Router) {

  }
  ngOnInit() {
    this.studentsService.getStudents()
      .subscribe({
        next : value => {
          this.students = value;
          this.studentsDataSource = new MatTableDataSource<Student>(this.students);
          this.studentsDataSource.paginator = this.paginator;
          this.studentsDataSource.sort = this.sort;
        },
        error: error => {
          console.log(error);
        }
      })
  }

  studentPayments(student: Student) {
    this.router.navigateByUrl(`/admin/student-details/${student.code}`);
  }
}
