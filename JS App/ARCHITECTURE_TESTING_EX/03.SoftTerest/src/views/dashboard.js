import { getAllIdeas } from "../api/data.js";
import { domElement } from "../dom.js";

const section = document.getElementById('dashboard-holder');
section.remove();
section.addEventListener('click', onDetailsClick);
let context = null;

export async function showDashboardPage(contextTarget) {
    context = contextTarget;
    context.showSection(section);
    loadIdeas();
    context.updateNav();
}

async function loadIdeas() {
    section.replaceChildren(domElement('h1', {}, 'Loading ideas...'));
    const ideas = await getAllIdeas();

    if (ideas.length == 0) {
        section.replaceChildren(domElement('h1', {}, 'No ideas yet! Be the first one :)'));
    } else {
        const fragment = document.createDocumentFragment();
        ideas.map(creareIdeaCard).forEach(ideaCard => fragment.appendChild(ideaCard));
        section.replaceChildren(fragment);
    }
}

function creareIdeaCard(idea) {
    const element = domElement('div', { className: 'card overflow-hidden current-card details' });
    element.style.width = '20rem';
    element.style.height = '18rem';
    element.innerHTML = `
        <div class="card-body">
            <p class="card-text">${idea.title}</p>
        </div>
        <img class="card-image" src="${idea.img}" alt="Card image cap">
        <a data-id="${idea._id}" class="btn" href="">Details</a>
        </div>`;
    return element;
}

function onDetailsClick(ev) {
    if (ev.target.tagName == 'A') {
        const id = ev.target.dataset.id;
        ev.preventDefault();
        context.goTo('details', id);
    }
}