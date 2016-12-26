import {Component, OnInit} from '@angular/core';
import {AuthService} from './auth.service';
import {Profile} from '../model/user-profile';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';

@Component({
  template: `
        <h2>Profile</h2>
        <li *ngFor="let profile of profiles | async">
      <span>{{ profile.name }}</span> {{ profile.description }}
    </li>
        <button (click)="logout()" *ngIf="authService.isLoggedIn()">Logout</button>
    `
})
export class ProfileComponent implements OnInit {

  private _profiles: Observable<Profile[]>;

  constructor(private authService: AuthService, private router: Router) {
  }

  get profiles(): Observable<Profile[]> {
    return this._profiles;
  }

  ngOnInit(): void {
    this._profiles = this.authService.getProfiles();
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/']);
  }
}
