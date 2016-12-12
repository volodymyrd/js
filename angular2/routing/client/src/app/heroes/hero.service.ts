import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';

import {Observable} from 'rxjs';

import {Hero} from '../model/hero';

@Injectable()
export class HeroService {

  constructor(private http: Http) {
  }

  getHero(id: Number): Observable<Hero[]> {
    console.log('HeroService.getHero');
    return this.http
      .get(`http://localhost:8080/api/hero/one/${id}`)
      .map((r: Response) => {
        console.log(r);
        let h: Hero[] = r.json() as Hero[];
        return h;
      });
  }

  getHeroes(): Observable<Hero[]> {
    console.log('HeroService.getHeroes');
    return this.http
      .get(`http://localhost:8080/api/hero/all`)
      .map((r: Response) => {
        console.log(r);
        let h: Hero[] = r.json() as Hero[];
        return h;
      });
  }
}
