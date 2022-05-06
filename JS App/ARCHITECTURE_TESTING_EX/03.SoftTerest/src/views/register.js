import { register } from "../api/data.js";
import { domElement } from "../dom.js";

const section = document.getElementById('register-page');
section.remove();

const form = section.querySelector('form');
form.addEventListener('submit', onSubmit);

let context = null;

export async function showRegisterPage(contextTarget) {
    context = contextTarget;
    context.showSection(section);
}

async function onSubmit(event) {

    event.preventDefault();
    const formData = new FormData(form);

    const email = formData.get('email').trim();
    const password = formData.get('password').trim();
    const repeatPassword = formData.get('repeatPassword').trim();
  
    if (!email || !password) {
        return alert('All fields are required');
    }
    if (password != repeatPassword) {
        return alert('Passwords do not match');
    }

    await register({ email, password });
    form.reset();
    context.goTo('home');
    context.updateNav();
}