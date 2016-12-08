/* tslint:disable:no-unused-variable */

import {TestBed, async} from '@angular/core/testing';
import {HeroesComponent} from './heroes.component';
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {HeroDetailComponent} from "./hero-detail.component";
import {HeroService} from "../services/hero.service";
import {RouterTestingModule} from "@angular/router/testing";

let title = "Tour of Heroes";
let h2 = "My Heroes";

describe('HeroesComponent', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [
        HeroesComponent, HeroDetailComponent
      ],
      providers: [HeroService],
      imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        [RouterTestingModule.withRoutes([
          { path: '', component: HeroesComponent }
        ])],
      ],
    });
  });

  it('should create the heroes component', async(() => {
    let fixture = TestBed.createComponent(HeroesComponent);
    let app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it(`should has element '.heroes'` + title, async(() => {
    let fixture = TestBed.createComponent(HeroesComponent);
    let compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('.heroes')).toBeTruthy();
  }));

  it('should render text in a h2 tag', async(() => {
    let fixture = TestBed.createComponent(HeroesComponent);
    fixture.detectChanges();
    let compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h2').textContent).toContain(h2);
  }));
});
