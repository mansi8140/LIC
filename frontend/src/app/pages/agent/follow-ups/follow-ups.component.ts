import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-follow-ups",
  templateUrl: "./follow-ups.component.html",
  styleUrls: ["../style.scss"],
  imports: [CommonModule, FormsModule],
})
export class FollowUpsComponent implements OnInit {
  followUps = [
    { client: "John Doe", task: "Policy Renewal", dueDate: "2025-01-20" },
    { client: "Jane Smith", task: "Claim Submission", dueDate: "2025-01-25" },
  ];

  constructor() {}

  ngOnInit(): void {}
}
