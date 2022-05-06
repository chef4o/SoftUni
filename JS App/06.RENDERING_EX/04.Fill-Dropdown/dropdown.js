import { html, render } from '../node_modules/lit-html/lit-html.js';

const url = 'http://localhost:3030/jsonstore/advanced/dropdown';
const root = document.getElementById('menu');
document.querySelector('form').addEventListener('submit', addItem);

const dropdownMenu = (items) => html`
    ${items && items.map(item => html`<option value=${item._id}>${item.text}</option>`)}`;

getData();

async function getData() {
    const res = await fetch(url);
    const data = await res.json();
    update(Object.values(data));
}

function update(items) {
    render(dropdownMenu(items), root);
}

async function addItem(ev) {
    const textField = document.getElementById('itemText');
    ev.preventDefault();
    const text = textField.value;

    const res = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ text })
    });

    if (res.ok) {
        textField.value = '';
        getData();
    }


}