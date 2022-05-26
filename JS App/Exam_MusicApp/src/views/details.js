import { getItemById, deleteItemById } from '../api/data.js';
import { html } from '../lib.js';
import { getUserData } from '../util.js';

const detailsTemplate = (item, isOwner, onDelete) => html`
<section id="detailsPage">
    <div class="wrapper">
        <div class="albumCover">
            <img src=${item.imgUrl}>
        </div>
        <div class="albumInfo">
            <div class="albumText">

                <h1>Name: ${item.name}</h1>
                <h3>Artist: ${item.artist}</h3>
                <h4>Genre: ${item.genre}</h4>
                <h4>Price: $${item.price}</h4>
                <h4>Date: ${item.releaseDate}</h4>
                <p>Description: ${item.description}</p>
            </div>

            ${isOwner 
                ? html`
                    <div class="actionBtn">
                    <a href="/edit/${item._id}" class="edit">Edit</a>
                    <a @click=${onDelete} href="/catalog" class="remove">Delete</a>
                </div>`
                : null}
        </div>
    </div>
</section>
`;

export async function detailsPage(ctx) {
    const item = await getItemById(ctx.params.id);

    const userData = getUserData();
    const isOwner = userData && userData.id == item._ownerId;

    if (userData) {
        ctx.render(detailsTemplate(item, isOwner, onDelete));

        async function onDelete() {
            deleteItemById(ctx.params.id);
            ctx.page.redirect('/catalog');
        }
    } else {
        ctx.page.redirect('/home');
    }
}