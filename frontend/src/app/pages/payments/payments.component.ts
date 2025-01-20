import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.scss'],
  imports: [FormsModule],
})
export class PaymentsComponent {
  paymentDetails = {
    policyNumber: '',
    amount: '',
  };

  onSubmit(event: Event) {
    event.preventDefault();
    console.log('Payment Submitted:', this.paymentDetails);
    alert(
      `Payment of ₹${this.paymentDetails.amount} for Policy #${this.paymentDetails.policyNumber} submitted successfully.`
    );
  }
}
