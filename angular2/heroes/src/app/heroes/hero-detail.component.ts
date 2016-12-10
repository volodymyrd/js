import {Component, Input, OnInit} from '@angular/core';
import {Location}       from '@angular/common';
import {Hero} from '../model/hero';
import {ActivatedRoute, Params} from '@angular/router';
import {HeroService} from '../services/hero.service';
import 'rxjs/add/operator/switchMap';


@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {
  @Input()
  hero: Hero;

  constructor(private heroService: HeroService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.heroService
      .update(this.hero)
      .then(() => this.goBack());
  }

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.heroService.getHero(+params['id']))
      .subscribe(hero => this.hero = hero);
  }
}
