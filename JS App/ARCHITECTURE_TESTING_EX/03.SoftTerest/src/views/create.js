import { createIdea } from "../api/data.js";

const section = document.getElementById('create-page');
section.remove();

const form = section.querySelector('form');
form.addEventListener('submit', onSubmit);

let context = null;

export async function showCreatePage(contextTarget) {
    context = contextTarget;
    context.showSection(section);
}

async function onSubmit(event) {
    event.preventDefault();

    const formData = new FormData(form);

    const title = formData.get('title').trim();
    const description = formData.get('description').trim();
    const img = formData.get('imageURL').trim();

    if (title.length < 6) {
        return alert('Title must be at leasr 6 characters long');
    }
    if (description.length < 10) {
        return alert('Title must be at leasr 10 characters long');
    }
    if (img.length < 5) {
        return alert('url must be at leasr 5 characters long');
    }

    createIdea({ title, description, img });
    form.reset();
    context.goTo('dashboard');
}