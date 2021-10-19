import { Component, OnInit } from '@angular/core';
import { Premium } from './premium';
import { EstimateService } from './estimate.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
@Component({
  selector: 'app-estimate',
  templateUrl: './estimate.component.html',
  styleUrls: ['./estimate.component.css'],
})
export class EstimateComponent {
  premium: Premium = new Premium();
  totalPremium: number = 0;


  constructor(private estimateService: EstimateService) { }

  calculateClaim() {
    alert(JSON.stringify(this.premium));

    if (this.premium.age <= 0.5) {
      this.premium.depreciationRate = 0.05;
    }
    else if (this.premium.age <= 1 && this.premium.age > 0.5) {
      this.premium.depreciationRate = 0.15;
    }
    else if (this.premium.age <= 2 && this.premium.age > 1) {
      this.premium.depreciationRate = 0.2;
    }
    else if (this.premium.age <= 3 && this.premium.age > 2) {
      this.premium.depreciationRate = 0.3;
    }
    else if (this.premium.age <= 4 && this.premium.age > 3) {
      this.premium.depreciationRate = 0.4;
    }
    else {
      this.premium.depreciationRate = 0.5;
    }


    this.totalPremium = (this.premium.totalCostOfVehicle - this.premium.totalCostOfVehicle * this.premium.depreciationRate) * this.premium.premiumRate * 0.01;
    console.log(this.totalPremium);
    this.totalPremium = this.totalPremium - this.totalPremium * this.premium.noClaimBonus * 0.01;

    alert("Your Premium is " + this.totalPremium);

    // this.estimateService.estimate(this.premium).subscribe((data: any) => {
    //   alert(JSON.stringify(data));
    // });
  }

  // ngOnInit() {
  //   this.premium.age = 0;
  // }

}
