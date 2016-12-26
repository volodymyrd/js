import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {AuthService} from './auth.service';

import {User} from '../model/user';

@Component({
  template: `
      <h2>LOGIN</h2>
    <p>{{message}}</p>
        <div>
            <label>User name: </label>
            <input [(ngModel)]="user.userName" placeholder="user name"/>
        </div>
        <div>
            <label>Password: </label>
            <input [(ngModel)]="user.password" placeholder="password"/>
        </div>
                
        <button (click)="login()"  *ngIf="!authService.isLoggedIn()">Login</button>
    `,
})
export class LoginComponent implements OnInit {
  private message: string;
  private user: User;

  ngOnInit(): void {
  }

  constructor(private authService: AuthService, private router: Router) {
    this.setMessage();
    this.user = new User();
  }

  setMessage() {
    console.log("setMessage");
    this.message = 'Logged ' + (this.authService.isLoggedIn() ? 'in' : 'out');
  }

  login() {
    this.message = 'Trying to log in ...';

    this.authService.login(this.user.userName, this.user.password)
      .subscribe(response => {
          console.log(response);
          if (response.status === 200) {
            this.setMessage();
            this.authService.setToken(response.headers.get('TOKEN_ACCESS'));
            // Get the redirect URL from our auth service
            // If no redirect has been set, use the default
            let redirect = this.authService.redirectUrl ? this.authService.redirectUrl : '/crisis-center/admin';
            // Redirect the user
            console.log("redirect: " + redirect);
            this.router.navigate([redirect]);
          }
        },
        error => this.message = <any>error);
  }
}
