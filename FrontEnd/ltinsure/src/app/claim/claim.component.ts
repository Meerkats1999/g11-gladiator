import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClaimInsuranceService } from '../claim-insurance.service';
import { ApproveClaim } from '../entity/approveClaim';
import { Claim } from '../entity/claim';

@Component({
  selector: 'app-claim',
  templateUrl: './claim.component.html',
  styleUrls: ['./claim.component.css'],
})
export class ClaimComponent implements OnInit {
  claim: Claim = new Claim();
  approveClaim: ApproveClaim = new ApproveClaim();
  maxAmt: number | undefined;

  constructor(
    private service: ClaimInsuranceService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
     this.activatedRoute.paramMap.subscribe((params) => {
       this.maxAmt = Number(params.get('amount'));
     });
  }

  claimInsurance() {
    this.service
      .claimInsurance(this.claimCustomerId(this.claim))
      .subscribe((data) => {
        alert(JSON.stringify(data));
      });

    this.router.navigate(['claimStatus']);
  }

  updateStatus() {
    this.service
      .updateStatus(this.approveClaimCustomerId(this.approveClaim))
      .subscribe((data) => {
        alert(JSON.stringify(data));
      });
  }

  claimCustomerId(claim: Claim) {
    claim.customerId = JSON.parse(sessionStorage.getItem('id')!);
    return claim;
  }

  approveClaimCustomerId(approveClaim: ApproveClaim) {
    approveClaim.customerId = JSON.parse(sessionStorage.getItem('id')!);
    return approveClaim;
  }

  ngOnInit(): void {}
}
