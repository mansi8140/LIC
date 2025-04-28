import { Component, OnInit } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";

@Component({
  selector: "app-audit-logs",
  templateUrl: "./audit-logs.component.html",
  styleUrls: ["../style.scss"],
  imports: [CommonModule, FormsModule],
})
export class AuditLogsComponent implements OnInit {
  logs = [
    {
      id: 1,
      action: "User Login",
      user: "John Doe",
      timestamp: "2025-01-20 10:00 AM",
    },
    {
      id: 2,
      action: "Policy Created",
      user: "Admin User",
      timestamp: "2025-01-19 03:15 PM",
    },
  ];

  searchQuery = "";

  constructor() {}

  ngOnInit(): void {}

  getFilteredLogs(): any[] {
    if (!this.searchQuery) {
      return this.logs;
    }
    return this.logs.filter((log) =>
      log.action.toLowerCase().includes(this.searchQuery.toLowerCase())
    );
  }
}
