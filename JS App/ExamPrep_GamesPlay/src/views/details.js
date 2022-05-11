import { getItemById, deleteItemById, getGameComments, addComment } from '../api/data.js';
import { html } from '../lib.js';
import { getUserData } from '../util.js';

const detailsTemplate = (item, isLogged, isOwner, comments, onDelete, onSubmit) => html`

<section id="game-details">
    <h1 id=${item._id}>Game Details</h1>
    <div class="info-section">

        <div class="game-header">
            <img class="game-img" src=${item.imageUrl}>
            <h1>${item.title}</h1>
            <span class="levels">MaxLevel: ${item.maxLevel}</span>
            <p class="type">${item.category}</p>
        </div>

        <p class="text">
            ${item.summary}
        </p>

        <!-- Bonus ( for Guests and Users ) -->
        <div class="details-comments">
            <h2>Comments:</h2>
            <ul>
                ${comments.length > 0 
                    ? comments.map(commentTemplate)
                    : html`<p class="no-comment">No comments.</p>`}
            </ul>
        </div>

        ${isLogged 
            ? html`
            <div class="buttons">
                <a href="/edit/${item._id}" class="button">Edit</a>
                <a @click=${onDelete} href="javascript:void(0)" class="button">Delete</a>
            </div>`
            : null}
    </div>

    <!-- Bonus -->
    <!-- Add Comment ( Only for logged-in users, which is not creators of the current game ) -->

    ${isLogged && !isOwner 
        ? html`
        <article class="create-comment">
            <label>Add new comment:</label>
            <form @submit=${onSubmit} class="form">
                <textarea name="comment" placeholder="Comment......"></textarea>
                <input class="btn submit" type="submit" value="Add Comment">
            </form>
        </article>`
        : null}

</section>`;

const commentTemplate = (comment) => html`
<!-- list all comments for current game (If any) -->
<li class="comment">
    <p>Content: ${comment}</p>
</li>`;

export async function detailsPage(ctx) {
    const item = await getItemById(ctx.params.id);
    const comments = [...await getGameComments(ctx.params.id)].map(e => e.comment);
    const userData = getUserData();
    const isOwner = userData && userData.id == item._ownerId;
    const isLogged = userData;

    ctx.render(detailsTemplate(item, isLogged, isOwner, comments, onDelete, onSubmit));

    async function onSubmit(ev) {
        ev.preventDefault();
        
        const gameId = ev.target.parentNode.parentNode.parentNode.querySelector('h1').id;
        const formData = new FormData(ev.target);
        const comment = formData.get('comment').trim();

        if (comment == '') {
            return alert('All fields are required');
        }

        await addComment({
                gameId,
                comment                  
        });

        ctx.page.redirect(`/details/${ctx.params.id}`);
    }

    async function onDelete() {
        const choice = confirm(`Are you sure you want to delete this item?`);
        if (choice) {
            await deleteItemById(ctx.params.id);
            ctx.page.redirect('/catalog');
        }
    }

}