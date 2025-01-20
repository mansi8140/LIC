import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { PolicyOverviewComponent } from './pages/policy-overview/policy-overview.component';
import { PaymentsComponent } from './pages/payments/payments.component';
import { SupportComponent } from './pages/support/support.component';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'policies', component: PolicyOverviewComponent },
  { path: 'payments', component: PaymentsComponent },
  { path: 'support', component: SupportComponent },
];
