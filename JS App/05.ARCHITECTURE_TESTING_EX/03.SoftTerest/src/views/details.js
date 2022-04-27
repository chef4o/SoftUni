import { deleteIdea, getIdeaById } from "../api/data.js";
import { domElement } from "../dom.js";

const section = document.getElementById('details-page');
section.remove();
let context = null;

export async function showDetailsPage(contextTarget, id) {
    context = contextTarget;
    context.showSection(section);
    loadIdea(id);
}

async function loadIdea(id) {
    section.replaceChildren(domElement('h2', {}, `Loading...`));
    const idea = await getIdeaById(id);
    section.replaceChildren(generateIdea(idea));
}

function generateIdea(idea) {
    const fragment = document.createDocumentFragment();
    fragment.appendChild(domElement('img', { className: 'det-img', src: `${idea.img}` }));
    fragment.appendChild(domElement('div', { className: 'desc' },
        domElement('h2', { className: 'display-5' }, idea.title),
        domElement('p', { className: 'infoType' }, 'Description:'),
        domElement('p', { className: 'idea-description' }, idea.description)
    ));

    const userData = JSON.parse(sessionStorage.getItem('userData'));
    if (userData && userData.id == idea._ownerId) {
        const deleteBtn = domElement('div', { className: 'text-center' },
            domElement('a', { id: `${idea._id}`, className: 'btn detb', href: '' }, 'Delete'));

        deleteBtn.addEventListener('click', async (event) => {
            event.preventDefault();
            const confirmed = confirm('Are you sure you want to delete this idea?');
            if (confirmed) {
                await deleteIdea(event.target.id);
                context.goTo('dashboard');
            }
        });

        fragment.appendChild(deleteBtn);
    }
    return fragment;
}