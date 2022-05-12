import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.css']
})
export class FormLoginComponent implements OnInit {
fomr: FormGroup;
  constructor() { }

  ngOnInit(): void {
    this.fomr = new FormGroup(
      {
        user: new FormControl('', [Validators.required, Validators.email]),
        password: new FormControl('', Validators.required),
      },
    );
  }

  submit() {
    console.log(this.fomr.value);
  }
}
