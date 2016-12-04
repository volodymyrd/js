import {ApiService} from "./api.service";
import {Injectable} from "@angular/core";

@Injectable()
export class RaceService {

    constructor(private apiService: ApiService) {
        console.log('apiService: ' + apiService);
    }

    list() {
        return this.apiService.get('/races')
    }
}