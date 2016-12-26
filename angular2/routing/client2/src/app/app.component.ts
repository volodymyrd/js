import {Component, OnInit} from '@angular/core';
import {AuthService} from './comps/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'app works!';

  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
    console.log('ngOnInit AppComponent');
    this.authService.refreshToken()
      .subscribe(response => {
        this.authService.setToken(response.json().token);
        console.log(this.authService.getToken());
      });
  }
}
