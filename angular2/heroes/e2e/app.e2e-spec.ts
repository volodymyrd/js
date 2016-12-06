import { HeroesPage } from './app.po';

let title = "Tour of Heroes";

describe('heroes App', function() {
  let page: HeroesPage;

  beforeEach(() => {
    page = new HeroesPage();
  });

  it('should display message saying ' + title, () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual(title);
  });
});
