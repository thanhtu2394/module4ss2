import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormControlName, FormGroup, Validators} from '@angular/forms';
import validate = WebAssembly.validate;
import {variable} from '@angular/compiler/src/output/output_ast';
import {min} from 'rxjs/operators';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  register: FormGroup;
  constructor() {
  }

  ngOnInit(): void {
    this.register = new FormGroup({
      Email: new FormControl('', [Validators.required, Validators.email]),
      Psw: new FormGroup({
        Password: new FormControl('', [Validators.required, Validators.minLength(6)]),
        ConfirmPW: new FormControl('', [Validators.required, Validators.minLength(6)]),
      }, this.comparePassword),
    Country: new FormControl(),
    Age: new FormControl(),
    Gender: new FormControl(),
    Phone: new FormControl(),
  }
  );
  }

  submit() {
    console.log(this.register.value);
  }
  comparePassword( c: AbstractControl) {
    const v = c.value;
    return (v.Password === v.ConfirmPW) ?
      null : {
      passwordnotmatch: true
    } ;
  }

}
