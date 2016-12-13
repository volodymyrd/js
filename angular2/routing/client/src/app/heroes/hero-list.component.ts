import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute, Params} from '@angular/router';
import {HeroService} from './hero.service';
import {Hero} from '../model/hero';
import {Observable} from 'rxjs';
import 'rxjs/add/operator/switchMap';

@Component({
  template: `
  <h2>HEROES</h2>
  <ul class="items">
    <li *ngFor="let hero of heroes | async"
        [class.selected]="isSelected(hero)"
        (click)="onSelect(hero)">
      <span class="badge">{{ hero.id }}</span> {{ hero.name }}
    </li>
  </ul>
`
})
export class HeroListComponent implements OnInit {

  heroes: Observable<Hero[]>;
  private selectedId: number;

  ngOnInit(): void {
    this.getHeroes();
  }

  constructor(private router: Router,
              private route: ActivatedRoute,
              private heroService: HeroService) {
  }

  onSelect(hero: Hero) {
    this.router.navigate(['/hero', hero.id]);
  }

  isSelected(hero: Hero) {
    return hero.id === this.selectedId;
  }

  private getHeroes(): void {
    this.heroes = this.route.params
      .switchMap((params: Params) => {
        this.selectedId = +params['id'];
        console.log(this.selectedId);
        return this.heroService.getHeroes();
      })
      .catch(error => {
        // TODO: real error handling
        console.log(error);
        return Observable.of<Hero[]>([]);
      });
  }
}
