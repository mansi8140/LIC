import { Component, OnInit } from "@angular/core";
import { Router, NavigationEnd } from "@angular/router";
import { RouterOutlet } from "@angular/router";
import { HeaderComponent } from "./components/header/header.component";
import { FooterComponent } from "./components/footer/footer.component";
import { NgIf } from "@angular/common";

@Component({
  selector: "app-root",
  imports: [RouterOutlet, HeaderComponent, FooterComponent, NgIf],
  templateUrl: "./app.component.html",
  styleUrl: "./app.component.scss",
})
export class AppComponent implements OnInit {
  showHeaderAndFooter: boolean = true;
  title = "lic-web-app";

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        // Define the routes where header and footer should be hidden
        const noHeaderFooterRoutes = ["/login"];
        this.showHeaderAndFooter = !noHeaderFooterRoutes.includes(
          event.urlAfterRedirects
        );
      }
    });
  }
}
