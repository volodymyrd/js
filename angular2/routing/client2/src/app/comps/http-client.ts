import {Injectable} from '@angular/core';
import {Http, Headers, Response} from '@angular/http';
import {Observable} from 'rxjs';

@Injectable()
export class HttpClient {

  constructor(private http: Http) {
  }

  get(url, token: string): Observable<Response> {
    return this.http.get(url, {
      headers: this.createAuthorizationHeader(token)
    });
  }

  post(url, data, token: string): Observable<Response> {
    return this.http.post(url, data, {
      headers: this.createAuthorizationHeader(token)
    });
  }

  private createAuthorizationHeader(token: string): Headers {
    let headers = new Headers();
    headers.append('TOKEN_ACCESS', token);
    return headers
  }
}
