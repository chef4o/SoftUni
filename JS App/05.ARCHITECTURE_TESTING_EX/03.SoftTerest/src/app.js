import { showCreatePage } from "./views/create.js";
import { showDashboardPage } from "./views/dashboard.js";
import { showDetailsPage } from "./views/details.js";
import { showHomePage } from "./views/home.js";
import { showLoginPage } from "./views/login.js";
import { showRegisterPage } from "./views/register.js";
import { showSection } from "./dom.js"
import { logout } from "./api/data.js";

const links = {
    'home-link': 'home',
    'get-started-link': 'home',
    'dashboard-link': 'dashboard',
    'create-link': 'create',
    'login-link': 'login',
    'register-link': 'register'
}

const views = {
    'home': showHomePage,
    'dashboard': showDashboardPage,
    'create': showCreatePage,
    'login': showLoginPage,
    'register': showRegisterPage,
    'details': showDetailsPage 
}

const nav = document.querySelector('nav');
nav.addEventListener('click', onNavigate);

document.getElementById('logout-btn').addEventListener('click', async (ev) => {
    ev.preventDefault();
    await logout();
    updateNav();
    goTo('home');
});

const context = {
    goTo,
    showSection,
    updateNav
}

goTo('home'); //Start in home view
updateNav();    

function onNavigate(event) {
    const view = links[event.target.id];
    if (view) {
        event.preventDefault();
        goTo(view);
    }
}

function goTo(view, ...params) {
    const viewMolel = views[view]; 
    if (typeof viewMolel == 'function') {
        viewMolel(context, ...params);
    }
}

function updateNav() {
    const userData = JSON.parse(sessionStorage.getItem('userData'));
    if (userData != null) {
        [...nav.querySelectorAll('.user')].forEach(link => link.style.display = 'block');
        [...nav.querySelectorAll('.guest')].forEach(link => link.style.display = 'none');
    } else {
        [...nav.querySelectorAll('.guest')].forEach(link => link.style.display = 'block');
        [...nav.querySelectorAll('.user')].forEach(link => link.style.display = 'none');
    }
}

