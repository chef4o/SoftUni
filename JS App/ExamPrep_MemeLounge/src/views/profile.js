import { getUserItems } from '../api/data.js';
import { html } from '../lib.js';
import { getUserData } from '../util.js';

const profileTemplate = (userData, items) => html`
<section id="user-profile-page" class="user-profile">
    <article class="user-info">
        <img id="user-avatar-url" alt="user-profile" src="/images/${userData.gender}.png">
        <div class="user-content">
            <p>Username: ${userData.username}</p>
            <p>Email: ${userData.email}</p>
            <p>My memes count: ${items.length}</p>
        </div>
    </article>
    <h1 id="user-listings-title">User Memes</h1>
    <div class="user-meme-listings">

        <!-- ? Display If there are no memes in database -->
        <!-- : Display All items in database ( If any ) -->

        ${items.length == 0 
            ? html`<p class="no-memes">No memes in database.</p>`
            : items.map(singleItemTemplate)}
        
    </div>
</section>
`;

const singleItemTemplate = (item) => html`
<div class="user-meme">
    <p class="user-meme-title">${item.title}</p>
    <img class="userProfileImage" alt="meme-img" src=${item.imageUrl}>
    <a class="button" href="/details/${item._id}">Details</a>
</div>
`;

export async function profilePage(ctx) {
    const userData = getUserData();
    const items = await getUserItems(userData.id);
    ctx.render(profileTemplate(userData, items));
}