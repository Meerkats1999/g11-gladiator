import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from './cutomer';
import { InsurancePlan } from './insurance_plan';
import { Policy } from './policy';
import { RenewService } from './renew.service';

@Component({
  selector: 'app-renew',
  templateUrl: './renew.component.html',
  styleUrls: ['./renew.component.css'],
})
export class RenewComponent implements OnInit {
  policy: Policy = new Policy();
  customer: Customer = new Customer();

  constructor(private renewService: RenewService, private router: Router) {}
  ngOnInit(): void {}

  renewPlan() {
    this.renewService.renew(this.policy).subscribe((data) => {
      //alert(JSON.stringify(data));
    });
    alert('Thank you ! Please proceed for payment');

    this.router.navigate(['renewpayment', this.policy.planAmount,this.policy.duration]);
  }
}
