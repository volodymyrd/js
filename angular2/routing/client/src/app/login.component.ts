import {Component}   from '@angular/core';
import {Router}      from '@angular/router';
import {AuthService} from './auth.service';
import {User} from './model/user';
@Component({
  template: `
    <h2>LOGIN</h2>
    <p>{{message}}</p>
        <div>
            <label>User name: </label>
            <input [(ngModel)]="user.userName" placeholder="password"/>
        </div>
        <div>
            <label>Password: </label>
            <input [(ngModel)]="user.password" placeholder="password"/>
        </div>
                
        <button (click)="login()"  *ngIf="!authService.isLoggedIn">Login</button>
        <button (click)="logout()" *ngIf="authService.isLoggedIn">Logout</button>
    `
})
export class LoginComponent {
  message: string;
  private user: User;

  constructor(public authService: AuthService, public router: Router) {
    this.setMessage();
  }

  setMessage() {
    this.message = 'Logged ' + (this.authService.isLoggedIn ? 'in' : 'out');
  }

  login() {
    this.message = 'Trying to log in ...';
    this.authService.login(this.user.userName, this.user.password).subscribe(() => {
      this.setMessage();
      if (this.authService.isLoggedIn) {
        // Get the redirect URL from our auth service
        // If no redirect has been set, use the default
        let redirect = this.authService.redirectUrl ? this.authService.redirectUrl : '/crisis-center/admin';
        // Redirect the user
        this.router.navigate([redirect]);
      }
    });
  }

  logout() {
    this.authService.logout();
    this.setMessage();
  }
}
