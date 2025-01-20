import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./pages/home/home.component";
import { PolicyOverviewComponent } from "./pages/policyUser/policy-overview/policy-overview.component";
import { PaymentsComponent } from "./pages/policyUser/payments/payments.component";
import { SupportComponent } from "./pages/policyUser/support/support.component";
import { LoginComponent } from "./pages/login/login.component";
import { ClientPoliciesComponent } from "./pages/agent/client-policies/client-policies.component";
import { CommissionsComponent } from "./pages/agent/commissions/commissions.component";
import { FollowUpsComponent } from "./pages/agent/follow-ups/follow-ups.component";
import { AuditLogsComponent } from "./pages/admin/audit-logs/audit-logs.component";
import { SystemOverviewComponent } from "./pages/admin/system-overview/system-overview.component";
import { UserManagementComponent } from "./pages/admin/user-management/user-management.component";

export const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "", redirectTo: "/login", pathMatch: "full" },
  { path: "home", component: HomeComponent },
  // User routes
  { path: "policies", component: PolicyOverviewComponent },
  { path: "payments", component: PaymentsComponent },
  { path: "support", component: SupportComponent },

  // Agent routes
  { path: "client-policies", component: ClientPoliciesComponent },
  { path: "commissions", component: CommissionsComponent },
  { path: "follow-ups", component: FollowUpsComponent },

  // Admin routes
  { path: "system-overview", component: SystemOverviewComponent },
  { path: "user-management", component: UserManagementComponent },
  { path: "audit-logs", component: AuditLogsComponent },
];
