import { Component, OnInit } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";

@Component({
  selector: "app-client-policies",
  templateUrl: "./client-policies.component.html",
  styleUrls: ["../style.scss"],
  imports: [CommonModule, FormsModule],
})
export class ClientPoliciesComponent implements OnInit {
  policies = [
    {
      client: "John Doe",
      policyName: "Life Cover Plus",
      status: "Active",
      premium: "₹5000",
    },
    {
      client: "Jane Smith",
      policyName: "Health Shield",
      status: "Pending",
      premium: "₹3000",
    },
  ];

  filter = "all"; // Default filter: Show all policies

  constructor() {}

  ngOnInit(): void {}

  getFilteredPolicies(): any[] {
    if (this.filter === "all") {
      return this.policies;
    }
    return this.policies.filter(
      (policy) => policy.status.toLowerCase() === this.filter.toLowerCase()
    );
  }
}
