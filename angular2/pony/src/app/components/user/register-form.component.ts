import {Component} from "@angular/core";
import {FormGroup, FormControl, FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'ns-register',
  templateUrl: 'register-form.component.html',
})
export class RegisterFormComponent {
  userFormGroup: FormGroup;
  passwordFormGroup: FormGroup;
  username: FormControl;
  password: FormControl;
  passwordConfirm: FormControl;
  //email: FormControl;
  passwordStrength: number = 0;


  constructor(fb: FormBuilder) {
    this.username = fb.control('', Validators.required);
    this.password = fb.control('', Validators.required);
    this.passwordConfirm = fb.control('', Validators.required);

    this.passwordFormGroup = fb.group({
        password: this.password,
        passwordConfirm: this.passwordConfirm
      },
      {validator: RegisterFormComponent.passwordMatch}
    );
    this.userFormGroup = fb.group({
        username: this.username,
        passwordFormGroup: this.passwordFormGroup
      }
    );

  }

  static passwordMatch(control: FormGroup) {
    let password = control.controls['password'].value;
    let confirm = control.controls['passwordConfirm'].value;

    return password === confirm ? null : {matchingError: true};
  }

  register() {
    console.log(this.userFormGroup.value);
  }
}
