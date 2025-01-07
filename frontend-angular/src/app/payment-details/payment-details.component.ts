import {Component, OnInit} from '@angular/core';
import {StudentsService} from "../services/students.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-payment-details',
  templateUrl: './payment-details.component.html',
  styleUrl: './payment-details.component.css'
})
export class PaymentDetailsComponent implements OnInit {

  paymentId!: number;
  pdfFileUrl:any;

  constructor(private studentsService: StudentsService, private router: ActivatedRoute) {
  }

  ngOnInit() {

    this.paymentId = this.router.snapshot.params['id'];
    this.studentsService.getPaymentDetails(this.paymentId).subscribe({
      next: value => {
        console.log('PDF Response:', value);
        let blob = new Blob([value], { type: 'application/pdf' });
        this.pdfFileUrl = window.URL.createObjectURL(blob);
        console.log('Generated PDF URL:', this.pdfFileUrl);
      },
      error: err => {
        console.error('Error fetching PDF:', err);
        alert('Failed to load PDF. Please try again later.');
      }
    });
  }

  afterLoadComplete(event: any) {
    console.log('PDF loaded successfully:', event);
  }
}
