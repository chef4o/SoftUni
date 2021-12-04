import * as data from './api/data.js';
import { page, render } from './lib.js';
import { getUserData } from './util.js';

import { catalogPage } from './views/catalog.js';
import { createPage } from './views/create.js';
import { detailsPage } from './views/details.js';
import { editPage } from './views/edit.js';
import { homePage } from './views/home.js';
import { loginPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { searchPage } from './views/search.js';

const root = document.querySelector('main');
document.getElementById('logoutBtn').addEventListener('click', onLogout);

page(decorateContext);
page('/', '/home');
page('/home', homePage);
page('/catalog', catalogPage);
page('/login', loginPage);
page('/register', registerPage);
page('/create', createPage);
page('/details/:id', detailsPage);
page('/edit/:id', editPage);
page('/search', searchPage);

updateUserNav()
page.start();

function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, root);
    ctx.updateUserNav = updateUserNav;
    next();
}

async function onLogout() {
    await data.logout();
    updateUserNav();
    page.redirect('/home');
}

function updateUserNav() {
    const userData = getUserData();

    if (userData) {
        [...document.querySelectorAll('.user')].forEach(element => element.style.display = 'inline-block');
        [...document.querySelectorAll('.guest')].forEach(element => element.style.display = 'none');
    } else {
        [...document.querySelectorAll('.guest')].forEach(element => element.style.display = 'inline-block');
        [...document.querySelectorAll('.user')].forEach(element => element.style.display = 'none');
    }
}