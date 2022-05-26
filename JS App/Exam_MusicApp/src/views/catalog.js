import { getAllData } from '../api/data.js';
import { getUserData } from '../util.js';
import { html } from '../lib.js';

const catalogTemplate = (items, loggedUser) => html`
<section id="catalogPage">
    <h1>All Albums</h1>
    ${items.length > 0 
            ? items.map(a => singleItemTemplate(a, loggedUser)) 
            : html`<p>No Albums in Catalog!</p>`}
</section>
`;

const singleItemTemplate = (item, loggedUser) => html`
<div class="card-box">
    <img src=${item.imgUrl}>
    <div>
        <div class="text-center">
            <p class="name">Name: ${item.name}</p>
            <p class="artist">Artist: ${item.artist}</p>
            <p class="genre">Genre: ${item.genre}</p>
            <p class="price">Price: $${item.price}</p>s
            <p class="date">Release Date: ${item.releaseDate}</p>
        </div>

        ${loggedUser == null
            ? null
            : html`
            <div class="btn-group">
                <a href="/details/${item._id}" id="details">Details</a>
            </div>`}
    </div>
</div>
`;

export async function catalogPage(ctx) {
    const loggedUser = getUserData(); 
    const items = await getAllData(); 
    ctx.render(catalogTemplate(items, loggedUser));
}