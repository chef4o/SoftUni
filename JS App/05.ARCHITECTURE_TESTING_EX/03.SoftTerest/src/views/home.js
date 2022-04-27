import { domElement } from "../dom.js";

const section = document.getElementById('home-page');
section.remove();
section.querySelector('#get-started-link').addEventListener('click', (ev) => {
    ev.preventDefault();
    context.goTo('dashboard');
});

let context = null;

export async function showHomePage(contextTarget) {
    context = contextTarget;
    context.showSection(section);
    context.updateNav();
}