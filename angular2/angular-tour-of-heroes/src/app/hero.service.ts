import {Injectable} from '@angular/core';
import {Hero} from './hero';
import {HEROES} from "./mockdata/mock-heroes";

@Injectable()
export class HeroService {
  getHeroes(): Promise<Hero[]> {
    return Promise.resolve(HEROES);
  }

  getHeroesSlowly(): Promise<Hero[]> {
    return new Promise<Hero[]>(resolve =>
      setTimeout(resolve, 3000)) // delay 2 seconds
      .then(() => this.getHeroes());
  }
}
