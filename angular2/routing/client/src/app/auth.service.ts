import {Injectable} from '@angular/core';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/delay';
import {Headers, Http} from '@angular/http';

@Injectable()
export class AuthService {
  private loggedIn: boolean = false;

  constructor(private http: Http) {
    //this.loggedIn = !!localStorage.getItem('auth_token');
  }

  // store the URL so we can redirect after logging in
  redirectUrl: string;

  login(userName: string, password: string): Observable<boolean> {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http
      .post(
        '/login',
        JSON.stringify({userName, password}),
        {headers}
      )
      .map(res => res.json())
      .map((res) => {
        if (res.success) {
          localStorage.setItem('auth_token', res.auth_token);
          this.loggedIn = true;
        }

        return res.success;
      });
  }

  logout(): void {
    this.loggedIn = false;
  }

  isLoggedIn() {
    return this.loggedIn;
  }
}
