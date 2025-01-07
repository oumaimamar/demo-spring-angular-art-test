import {Component, OnInit} from '@angular/core';
import {StudentsService} from "../services/students.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Payment} from "../model/students.model";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrl: './student-details.component.css'
})
export class StudentDetailsComponent implements OnInit {
  studentCode! : string;
  studentsPayments! : Array<Payment>;
  paymentsDataSource! : MatTableDataSource<Payment>;
  public displayedColumns = ['id','date','type','status','amount','firstName','details'];


  constructor(private activatedRoute: ActivatedRoute,
              private studentsService: StudentsService,
              private router: Router) { }

  ngOnInit() {
    this.studentCode = this.activatedRoute.snapshot.params['code'];
    this.studentsService.getStudentsPayments(this.studentCode).subscribe({
      next: value => {
        this.studentsPayments = value;
        this.paymentsDataSource = new MatTableDataSource<Payment>(this.studentsPayments);
      },
      error: err => {
        console.log(err);
      }
      }
    );
  }

  newPayment() {
    this.router.navigateByUrl(`/admin/new-payment/${this.studentCode}`);
  }

  paymentDetails(payment:Payment) {

    this.router.navigateByUrl(`/admin/payment-details/${payment.id}`);

  }
}
