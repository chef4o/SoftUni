// For debugging:
import * as data from './api/data.js';
import * as api from './api/api.js';

window.data = data;
window.api = api;

import { page, render } from './lib.js';
import { homePage } from './views/home.js';
import { catalogPage } from './views/catalog.js';
import { loginPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { getUserData } from './util.js';
import { createPage } from './views/create.js';
import { detailsPage } from './views/details.js';
import { editPage } from './views/edit.js';
import { profilePage } from './views/profile.js';

const root = document.querySelector('main'); 4
document.getElementById('logoutBtn').addEventListener('click', onLogout);

page(decorateContext);
page('/', '/home');
page('/home', homePage);
page('/memes', catalogPage);
page('/login', loginPage);
page('/register', registerPage);
page('/create', createPage);
page('/details/:id', detailsPage);
page('/edit/:id', editPage);
page('/profile/', profilePage);

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
    page.redirect('/');
}

function updateUserNav() {
    const userData = getUserData();

    if (userData) {
        document.querySelector('.user').style.display = 'block';
        document.querySelector('.user span').textContent = `Welcome, ${userData.email}`;
        document.querySelector('.guest').style.display = 'none';
    } else {
        document.querySelector('.guest').style.display = 'block';
        document.querySelector('.user').style.display = 'none';
    }

}