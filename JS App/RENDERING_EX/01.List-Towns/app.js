import { html, render } from '../node_modules/lit-html/lit-html.js';

const townsList = document.querySelector('#root');

document.querySelector('form').addEventListener('submit', (event) => {
    event.preventDefault();
    const towns = document.getElementById('towns').value.split(',').map(t => t.trim());
    const result = listTemplate(towns);
    render(result, townsList);
});

const listTemplate = (towns) => html`
    <ul>
        ${towns.map(town => html`<li>${town}</li>`)}
    </ul>
`;