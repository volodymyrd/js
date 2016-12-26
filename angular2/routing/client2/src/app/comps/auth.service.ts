import {Injectable} from '@angular/core';
import {Headers, Http, Response} from '@angular/http';
import {Observable} from 'rxjs';
import 'rxjs/Rx';
import {HttpClient} from './http-client';
import {Profile} from '../model/user-profile';

@Injectable()
export class AuthService {
  private token: string;

  constructor(private http: Http, private httpClient: HttpClient) {
    console.log('constructor AuthService');
  }

  // store the URL so we can redirect after logging in
  redirectUrl: string;

  login(username: string, password: string): Observable<Response> {
    let headers = new Headers();
    headers.append('Authorization', 'Basic ' +
      btoa(username + ':' + password));

    return this.http.post('/auth/signin', {}, {
      headers: headers
    })
    //.map(this.extractLoginData)\
      .catch(this.handleError)
      ;
  }

  // private extractData(res: Response) {
  //   let body = res.json();
  //   return body.data || {};
  // }

  logout(): void {
    this.httpClient.post('/auth/signout', {}, this.getToken())
      .catch(this.handleError)
      .subscribe(response => {
        this.token = null;
      });
  }

  isLoggedIn(): boolean {
    console.log('isLoggedIn:' + this.token);

    return this.token ? true : false;
  }

  setToken(token: string): void {
    this.token = token;
  }

  getToken(): string {
    return this.token;
  }

  refreshToken(): Observable<Response> {
    return this.http.post('/auth/token', {}, {})
      .catch(this.handleError)
      ;
  }

  getProfiles(): Observable<Profile[]> {
    return this.httpClient.post('/auth/profiles', {}, this.getToken())
      .catch(this.handleError)
      .map(response => {
        let profilesJson: Profile[] = response.json() as Profile[];

        console.log(profilesJson);
        return profilesJson;
      })
      ;
  }

  private handleError(error: Response | any) {
    console.error('handleError: ' + error);
    let errMsg: string;
    if (error instanceof Response) {
      //const body = error.json() || '';
      //const err = body.error || JSON.stringify(body);
      //errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
      errMsg = error.text();
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
