import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { HttpClient } from "@angular/common/http";
import { FormsModule } from "@angular/forms";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.scss"],
  imports: [FormsModule],
})
export class LoginComponent {
  loginData = {
    role: "",
  };

  constructor(private router: Router) {}

  onSubmit(): void {
    if (this.loginData.role) {
      this.authenticateUser(this.loginData);
      this.router.navigate(["/home"]);
    } else {
      alert("Please enter your email and password!");
    }
  }

  authenticateUser(data: { role: string }): void {
    switch (data.role) {
      case "user":
        localStorage.setItem("userRole", "user");
        break;
      case "agent":
        localStorage.setItem("userRole", "agent");
        break;
      case "admin":
        localStorage.setItem("userRole", "admin");

        break;
      default:
        console.error("Invalid role");
    }
  }
}
