import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';

import {Observable} from 'rxjs';

import {Hero} from '../model/hero';

@Injectable()
export class HeroService {

  constructor(private http: Http) {
  }

  getHeroes(): Observable<Hero[]> {
    console.log('HeroService.getHeroes');
    return this.http
      .get(`http://localhost:8080/api/hero/heroes`)
      .map((r: Response) => {
        console.log(r);
        let h: Hero[] = r.json() as Hero[];
        return h;
      });
  }
}
