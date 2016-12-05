import 'rxjs/add/operator/map';
import {BaseRequestOptions, Http, Response, ResponseOptions, RequestMethod} from "@angular/http";
import {MockBackend, MockConnection} from "@angular/http/testing";
import {async, TestBed, inject} from "@angular/core/testing";
import {RaceService} from "./race.service";
import {Race} from "../model/race";

describe('RaceService', () => {

  let raceService;
  let mockBackend;

  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      MockBackend,
      BaseRequestOptions,
      {
        provide: Http,
        useFactory: (backend, defaultOptions) => new Http(backend, defaultOptions),
        deps: [MockBackend, BaseRequestOptions]
      },
      RaceService
    ]
  }));

  beforeEach(inject([RaceService, MockBackend], (service, mock) => {
    raceService = service;
    mockBackend = mock;
  }));

  it('should return an Observable of 2 races', async(() => {
    // fake response
    let hardcodedRaces = [new Race('London'), new Race('Lyon')];
    let response = new Response(new ResponseOptions({body: hardcodedRaces}));
    // on a the connection
    mockBackend.connections.subscribe((connection: MockConnection) => {
      // return the fake response when we receive a request
      connection.mockRespond(response);
    });

    // call the service
    raceService.list().subscribe(races => {
      // check that the returned array is deserialized as expected
      expect(races.length).toBe(2);
    });

    // on a the connection
    mockBackend.connections.subscribe((connection: MockConnection) => {
      // return the fake response when we receive a request
      connection.mockRespond(response);

      // check that the underlying HTTP request was correct
      expect(connection.request.method).toBe(RequestMethod.Get);
      expect(connection.request.url).toBe('/api/races');
    });
  }));
});
