import { Policy } from './../renew/policy';
import { UserDashboardService } from './user-dashboard.service';
import { PolicyService } from './../policy.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css'],
})
export class UserDashboardComponent implements OnInit {
  id = sessionStorage.getItem('id');
  name = sessionStorage.getItem('name');
  role = sessionStorage.getItem('role');
  policies: any;
  constructor(private service: UserDashboardService, private router: Router) {}

  ngOnInit(): void {
    this.service.getAllPolicies().subscribe((data: any) => {
      this.policies = data;
    });
    console.log(this.id);
  }


  logout() {
    sessionStorage.clear();

    this.router.navigate(['home']);
  }
}
