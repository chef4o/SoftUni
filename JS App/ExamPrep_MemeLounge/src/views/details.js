import { getItemById, deleteItemById } from '../api/data.js';
import { html } from '../lib.js';
import { getUserData } from '../util.js';

const detailsTemplate = (item, isOwner, onDelete) => html`
<section id="meme-details">
    <h1>${item.title}</h1>
    <div class="meme-details">
        <div class="meme-img">
            <img alt="meme-alt" src=${item.imageUrl}>
        </div>
        <div class="meme-description">
            <h2>Meme Description</h2>
            <p>${item.description}</p>

            <!-- Buttons Edit/Delete should be displayed only for creator of this meme  -->
            ${isOwner 
                ? html`            
                    <a class="button warning" href="/edit/${item._id}">Edit</a>
                    <button @click=${onDelete} class="button danger">Delete</button>`
                : null}

        </div>
    </div>
</section>
`;

export async function detailsPage(ctx) {
    const item = await getItemById(ctx.params.id);

    const userData = getUserData();
    const isOwner = userData && userData.id == item._ownerId;

    ctx.render(detailsTemplate(item, isOwner, onDelete));

    async function onDelete() {

        //confirmation dialog:
        const choice = confirm(`Are you sure you want to delete this item?`);
        
        if (choice) {
            await deleteItemById(ctx.params.id);
            ctx.page.redirect('/memes');
        }

    }
}