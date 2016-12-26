import {Profile} from './user-profile';
export class User {
  private _userName: string;
  private _email: string;
  private _password: string;
  private _profiles: Profile[];


  get userName(): string {
    return this._userName;
  }

  set userName(value: string) {
    this._userName = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get profiles(): Profile[] {
    return this._profiles;
  }

  set profiles(value: Profile[]) {
    this._profiles = value;
  }
}
