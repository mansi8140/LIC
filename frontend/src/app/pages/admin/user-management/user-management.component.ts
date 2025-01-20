import { CommonModule } from "@angular/common";

import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-user-management",
  templateUrl: "./user-management.component.html",
  styleUrls: ["../style.scss"],
  imports: [CommonModule],
})
export class UserManagementComponent implements OnInit {
  users = [
    { id: 1, name: "John Doe", email: "john@example.com", role: "User" },
    { id: 2, name: "Jane Smith", email: "jane@example.com", role: "Agent" },
    { id: 3, name: "Admin User", email: "admin@example.com", role: "Admin" },
  ];

  constructor() {}

  ngOnInit(): void {}

  deleteUser(id: number): void {
    this.users = this.users.filter((user) => user.id !== id);
  }
}
