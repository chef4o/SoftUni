import { getAllData } from '../api/data.js';
import { getUserData } from '../util.js';
import { html } from '../lib.js';

const catalogTemplate = (items) => html`
<section id="catalog-page">
    <h1>All Games</h1>
    <!-- Display div: with information about every game (if any) -->
   
    ${items.length > 0 
        ? items.map(singleItemTemplate)
        : html`<h3 class="no-articles">No articles yet</h3>`}
    

    <!-- Display paragraph: If there is no games  -->
   
</section>
`;

const singleItemTemplate = (item) => html`
<div class="allGames">
    <div class="allGames-info">
        <img src=${item.imageUrl}>
        <h6>${item.category}</h6>
        <h2>${item.title}</h2>
        <a href="/details/${item._id}" class="details-button">Details</a>
    </div>

</div>
`;

export async function catalogPage(ctx) {
    const loggedUser = getUserData(); 
    const items = await getAllData(); 
    ctx.render(catalogTemplate(items, loggedUser));
}