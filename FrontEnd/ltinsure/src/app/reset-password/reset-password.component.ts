import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResetPasswordService } from './reset-password.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css'],
})
export class ResetPasswordComponent implements OnInit {
  newPassword: string | undefined;
  retypeNewPassword: string | undefined;

  isNotSame = false;

  reset = new ResetDto();

  constructor(private service: ResetPasswordService, private router: Router) { }

  ngOnInit(): void { }

  checkIfSame() {
    if (this.newPassword != this.retypeNewPassword) {
      this.isNotSame = true;
    } else {
      this.isNotSame = false;
    }
  }

  resetPassword() {
    this.reset.emailId = sessionStorage.getItem("email")?.toString();
    console.log(this.reset.emailId);
    this.reset.newPassword = this.newPassword;

    this.service.resetPassword(this.reset).subscribe((dataDto) => {
      let data: any;
      data = dataDto;
      if (data.status == 'SUCCESS') {
        this.router.navigate(['login']);
      } else {
        this.router.navigate(['home']);
      }
    });
  }
}

export class ResetDto {
  emailId: string | undefined;
  newPassword: string | undefined;
}
