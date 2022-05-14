import { getAllData } from '../api/data.js';
import { html } from '../lib.js';

const catalogTemplate = (items) => html`
<section id="meme-feed">
    <h1>All Memes</h1>
    <div id="memes">
        <!-- ? Display If there are no memes in database -->
        <!-- : Display All items in database ( If any ) -->
        ${items.length == 0 
            ? html`<p class="no-memes">No memes in database.</p>`
            : items.map(singleItemTemplate)}
    </div>
</section>
`;

const singleItemTemplate = (item) => html`
<div class="meme">
    <div class="card">
        <div class="info">
            <p class="meme-title">${item.title}</p>
            <img class="meme-image" alt="meme-img" src=${item.imageUrl}>
        </div>
        <div id="data-buttons">
            <a class="button" href="/details/${item._id}">Details</a>
        </div>
    </div>
</div>
`;

export async function catalogPage(ctx) {
    const items = await getAllData(); 
    ctx.render(catalogTemplate(items));
}