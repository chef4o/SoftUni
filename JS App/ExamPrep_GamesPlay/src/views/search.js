import { getSearchItems } from '../api/data.js';
import { getUserData } from '../util.js';
import { html } from '../lib.js';

const searchTemplate = (items, loggedUser, onClick) => html`
< <section id="searchPage">
    <h1>Search by Name</h1>

    <div class="search">
        <input id="search-input" type="text" name="search" placeholder="Enter desired albums's name">
        <button @click=${onClick} class="button-list">Search</button>
    </div>

    <h2>Results:</h2>

    <div class="search-result">
        ${items.length > 0
            ? items.map(a => singleItemTemplate(a, loggedUser)) 
            : html`<p class="no-result">No result.</p>`}
    </div>
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
            <p class="price">Price: $${item.price}</p>
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

export function searchPage(ctx) {

    const loggedUser = getUserData();
    const items = [];

    ctx.render(searchTemplate(items, loggedUser, onClick));

    async function onClick(ev) {
        const phrase = ev.target.parentNode.querySelector('#search-input').value.trim();
        const filteredItems = await getSearchItems(phrase);
        
        ctx.render(searchTemplate(filteredItems, loggedUser, onClick));
    }
}   