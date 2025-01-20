import { Component, OnInit } from "@angular/core";
import { CommonModule } from "@angular/common";
import { Router, RouterLink } from "@angular/router";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.scss"],
  imports: [CommonModule, RouterLink],
})
export class HomeComponent implements OnInit {
  role: string = ""; // User role ('user', 'agent', 'admin')
  cards: any[] = []; // Card data

  ngOnInit(): void {
    // Fetch user role (from localStorage, JWT, or API)
    this.role = localStorage.getItem("userRole") || "unknown";

    // Load cards based on role
    this.loadCardsForRole();
  }

  loadCardsForRole(): void {
    switch (this.role) {
      case "user":
        this.cards = [
          {
            title: "View Policies",
            description: "Access all your policy details.",
            link: "/policies",
          },
          {
            title: "Make Payments",
            description: "Pay your premiums securely.",
            link: "/payments",
          },
          {
            title: "Support",
            description: "Support.",
            link: "/support",
          },
        ];
        break;

      case "agent":
        this.cards = [
          {
            title: "Client Policies",
            description: "View and manage your clients’ policies.",
            link: "/client-policies",
          },
          {
            title: "Commissions",
            description: "Track your commission earnings.",
            link: "/commissions",
          },
          {
            title: "Follow-ups",
            description: "Check follow-up reminders for clients.",
            link: "/follow-ups",
          },
        ];
        break;

      case "admin":
        this.cards = [
          {
            title: "System Overview",
            description: "View system stats and analytics.",
            link: "/system-overview",
          },
          {
            title: "User Management",
            description: "Add, update, or delete users.",
            link: "/user-management",
          },
          {
            title: "Audit Logs",
            description: "View system activity logs.",
            link: "/audit-logs",
          },
        ];
        break;

      default:
        this.cards = [
          {
            title: "Unauthorized",
            description: "Contact support for access.",
            link: "/support",
          },
        ];
    }
  }
}
