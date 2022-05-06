import { towns as townNames } from './towns.js';
import { html, render } from '../node_modules/lit-html/lit-html.js';

const towns = townNames.map(town => ({ name: town, match: false }));
const root = document.getElementById('towns');
const input = document.getElementById('searchText');
const result = document.getElementById('result');
document.querySelector('button').addEventListener('click', onSearch);

const listTemplates = (towns) => html`
<ul>
   ${towns.map(town => html`<li class="${town.match ? 'active' : ''}">${town.name}</li>`)}
</ul>`;

function update() {
   render(listTemplates(towns), root);
}
update();

function onSearch() {
   const match = input.value.trim().toLocaleLowerCase();
   const matches = towns.filter(town => {
      match && town.name.toLocaleLowerCase().includes(match) ? town.match = true : town.match = false;
      return town.match;
   }).length;
   result.textContent = `${matches} matches found`;
   update();
}