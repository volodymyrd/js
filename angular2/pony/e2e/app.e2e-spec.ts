import { PonyPage } from './app.po';

describe('pony App', function() {
  let page: PonyPage;

  beforeEach(() => {
    page = new PonyPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
