import { page, render } from './lib.js';
import { getUserData } from './util.js';
import { catalogPage } from './views/catalog.js';
import { createPage } from './views/create.js';
import { detailsPage } from './views/details.js';
import { loginPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { editPage } from './views/edit.js';

const root = document.querySelector('main');

page(decorateContext);
page('/home', catalogPage);
page('/details/:id', detailsPage);
page('/create', createPage);
page('/login', loginPage);
page('/register', registerPage);
page('/edit/:id', editPage);
page('/', '/home');

updateNav();
page.start();

async function decorateContext(ctx, next) {
    ctx.render = (template) => render(template, root);
    ctx.updateNav = updateNav;
    next(); 
}   

function updateNav() {
    const userData = getUserData();
    if (userData != null) {
        [...document.querySelectorAll('nav .user')].forEach(element => element.style.display = 'block');
        [...document.querySelectorAll('nav .guest')].forEach(element => element.style.display = 'none');
        document.getElementById('welcomeMsg').textContent = `Welcome, ${userData.email}`;
    } else {
        [...document.querySelectorAll('nav .user')].forEach(element => element.style.display = 'none');
        [...document.querySelectorAll('nav .guest')].forEach(element => element.style.display = 'block');
        document.getElementById('welcomeMsg').textContent = '';
    }
}