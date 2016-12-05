import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import 'rxjs/add/operator/map';

@Injectable()
export class RaceService {

  constructor(private http: Http) {
  }

  list() {
    return this.http.get('/api/races').map(res => res.json());
  }
}
