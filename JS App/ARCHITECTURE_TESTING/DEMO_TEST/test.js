const { chromium } = require('playwright');
const { expect } = require('chai');

let browser, page;

describe('E2E Testing', function () {
    before(async () => { browser = await chromium.launch(); });
    after(async () => { await browser.close(); });
    beforeEach(async () => {page = await browser.newPage(); });
    afterEach(async () => {page.close(); });
});

(async () => {
    const browser = await chromium.launch();
    const page = await browser.newPage();
    await page.goto('https://google.com');
    await page.screenshot({path: 'example.png'});
    await browser.close();
})();