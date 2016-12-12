import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HeroService} from './hero.service';
import {Hero} from '../model/hero';
import {Observable} from 'rxjs';

@Component({
  template: `
  <h2>HEROES</h2>
  <ul class="items">
    <li *ngFor="let hero of heroes | async"
      (click)="onSelect(hero)">
      <span class="badge">{{ hero.id }}</span> {{ hero.name }}
    </li>
  </ul>
`
})
export class HeroListComponent implements OnInit {

  heroes: Observable<Hero[]>;

  ngOnInit(): void {
    this.getHeroes();
  }

  constructor(private router: Router,
              private heroService: HeroService) {
  }

  onSelect(hero: Hero) {
    this.router.navigate(['/hero', hero.id]);
  }

  private getHeroes(): void {
    this.heroes = this.heroService.getHeroes()
      .catch(error => {
        // TODO: real error handling
        console.log(error);
        return Observable.of<Hero[]>([]);
      });
  }
}
