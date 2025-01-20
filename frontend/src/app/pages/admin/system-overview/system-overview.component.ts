import { CommonModule } from "@angular/common";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-system-overview",
  templateUrl: "./system-overview.component.html",
  styleUrls: ["../style.scss"],
  imports: [CommonModule],
})
export class SystemOverviewComponent implements OnInit {
  overviewData = {
    totalPolicies: 150,
    totalPayments: "₹3,00,000",
    totalClaims: 20,
    totalUsers: 50,
  };

  constructor() {}

  ngOnInit(): void {
    // Fetch overview data from API when integrated
  }
}
