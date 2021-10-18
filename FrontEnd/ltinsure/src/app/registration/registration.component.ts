import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataDto } from '../login/data.dto';
import { Customer } from '../model/customer';
import { RegisterationService } from './registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  datadto: DataDto = new DataDto();
  customer: Customer = new Customer();
  successfull: boolean = false;
  constructor(
    private customerService: RegisterationService,
    private router: Router
  ) {}

  ngOnInit(): void {
  }

  register() {
    this.customerService.register(this.customer).subscribe((data) => {
      if (data.status == 'SUCCESS') {
        this.router.navigate(['login']);
      } else {
        //If error re register
        alert(JSON.stringify(data));
        this.router.navigate(['register']);
      }
    });
  }
}
