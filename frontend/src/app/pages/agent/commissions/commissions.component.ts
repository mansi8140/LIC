import { CommonModule } from "@angular/common";
import { Component, OnInit } from "@angular/core";
import { FormsModule } from "@angular/forms";

@Component({
  selector: "app-commissions",
  templateUrl: "./commissions.component.html",
  styleUrls: ["../style.scss"],
  imports: [CommonModule, FormsModule],
})
export class CommissionsComponent implements OnInit {
  totalCommission = "₹25,000";
  commissionDetails = [
    { policyName: "Life Cover Plus", commission: "₹5000", date: "2025-01-01" },
    { policyName: "Health Shield", commission: "₹3000", date: "2024-12-15" },
  ];

  constructor() {}

  ngOnInit(): void {}
}
