import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private baseUrl = 'https://api.example.com'; // Replace with actual API URL

  constructor(private http: HttpClient) {}

  getPolicies(): Observable<any> {
    return this.http.get(`${this.baseUrl}/policies`);
  }
}
