const { chromium } = require('playwright');
const { expect } = require('chai');

let browser, page;

describe('E2E Testing', async function () {
    this.timeout(5000);

    before(async () => { browser = await chromium.launch(); });
    after(async () => { await browser.close(); });
    beforeEach(async () => { page = await browser.newPage(); });
    afterEach(async () => { page.close(); });

    it('initialLoad', async () => {
        await page.goto('http://localhost:5501/05.ARCHITECTURE_TESTING/01.%20Accordion/');
        await page.waitForSelector('.accordion');

        const content = await page.textContent('#main');
        expect(content).to.contain('Scalable Vector Graphics');
        expect(content).to.contain('Open standard');
        expect(content).to.contain('Unix');
        expect(content).to.contain('ALGOL');
    })

    it('More button works', async function () {                                                 
        await page.goto('http://localhost:5501/05.ARCHITECTURE_TESTING/01.%20Accordion/');
        await page.waitForSelector('.accordion');

        await page.click('text=More');

        await page.waitForResponse(/articles\/details/i);

        await page.waitForSelector('.accordion p');
        const visible = await page.isVisible('.accordion p');

        expect(visible).to.be.true;
    });

    it.only('Less button wortks', async function () {                                       //it.only -> test only this test
        await page.goto('http://localhost:5501/05.ARCHITECTURE_TESTING/01.%20Accordion/');
        await page.waitForSelector('.accordion');

        await page.click('text=More');
        await page.waitForResponse(/articles\/details/i);
        await page.waitForSelector('.accordion p', { state: 'visible' });
        
        await page.click('text=Less');
        const visible = await page.isVisible('.accordion p');
        expect (visible).to.be.false;
    });

});