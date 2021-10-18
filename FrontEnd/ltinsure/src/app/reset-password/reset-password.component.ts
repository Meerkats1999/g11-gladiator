import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResetPasswordService } from './reset-password.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css'],
})
export class ResetPasswordComponent implements OnInit {
  oldPassword: string | undefined;
  newPassword: string | undefined;

  reset = new ResetDto();

  constructor(private service: ResetPasswordService, private router: Router) {}

  ngOnInit(): void {}

  resetPassword() {
    this.reset.email = JSON.parse(sessionStorage.getItem('email')!);
    this.reset.oldPassword = this.oldPassword;
    this.reset.oldPassword = this.oldPassword;

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
  email: string | undefined;
  oldPassword: string | undefined;
  newPassword: string | undefined;
}
