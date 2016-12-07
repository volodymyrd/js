import {Injectable} from "@angular/core";
import {Hero} from "../model/hero";
import {HEROES} from "./mock-heroes";

@Injectable()
export class HeroService {

  getHeroesSlowly(): Promise<Hero[]> {
    return new Promise<Hero[]>(resolve => setTimeout(resolve, 2000)).then(() => this.getHeroes());
  }

  getHeroes(): Promise<Hero[]> {
    return Promise.resolve(HEROES);
  }
}
