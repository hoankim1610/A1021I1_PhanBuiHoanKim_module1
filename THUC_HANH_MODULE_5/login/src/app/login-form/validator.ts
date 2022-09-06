import {AbstractControl, ValidationErrors} from "@angular/forms";

export function chargePassword (control: AbstractControl): ValidationErrors | null {
  const check = control.value;
  return (check.password === check.confirmPassword) ? null : {passwordNotMatch: true};
}
