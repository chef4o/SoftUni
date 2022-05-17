import { getItemById, deleteItemById, getLikeDataByMovie, likeItem } from '../api/data.js';
import { html } from '../lib.js';
import { getUserData } from '../util.js';

const detailsTemplate = (item, isLogged, isOwner, likes, onDelete, onLike) => html`
<section id="detailsPage">
    <div id="detailsBox">
        <div class="detailsInfo">
            <h1>Title: ${item.title}</h1>
            <div>
                <img src=${item.imageUrl}/>
            </div>
        </div>

        <div class="details">
            <h3>Theater Description</h3>
            <p>${item.description}</p>
            <h4>Date: ${item.date}</h4>
            <h4>Author: ${item.author}</h4>


            <div id=${item._id} class="buttons">

                ${isOwner
                    ? html`
                    <a @click=${onDelete} class="btn-delete" href="javascript:void(0)">Delete</a>
                    <a class="btn-edit" href="/edit/${item._id}">Edit</a>`
                    : null}

                ${isLogged && !isOwner
                    ? html`<a @click=${onLike} class="btn-like" href="javascript:void(0)">Like</a>`
                    : null}
            </div>
            
            <p class="likes">Likes: ${likes}</p>

        </div>

    </div>

</section>
`;

export async function detailsPage(ctx) {
    const item = await getItemById(ctx.params.id);
    const likes = await getLikeDataByMovie(ctx.params.id);
    const userData = getUserData();
    const isOwner = userData && userData.id == item._ownerId;
    const isLogged = userData;

    ctx.render(detailsTemplate(item, isLogged, isOwner, likes, onDelete, onLike));

    async function onLike(ev) {

        const likeBtn = ev.target;
        const theaterId = likeBtn.parentNode.id;
        likeBtn.style.display = 'none';
        await likeItem( { theaterId } );
        
        const likes = likeBtn.parentNode.parentNode.querySelector('.likes');
        const likesNumber = await getLikeDataByMovie(theaterId);
        likes.textContent = `Likes: ${likesNumber}`; 
    }

    async function onDelete() {
        const choice = confirm(`Are you sure you want to delete this item?`);
        if (choice) {
            await deleteItemById(ctx.params.id);
        }
    }

}