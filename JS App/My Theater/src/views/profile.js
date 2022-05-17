import { getProfileData } from '../api/data.js';
import { getUserData } from '../util.js';
import { html } from '../lib.js';

const profileTemplate = (userData, items) => html`
<section id="profilePage">
    <div class="userInfo">
        <div class="avatar">
            <img src="./images/profilePic.png">
        </div>
        <h2>${userData.email}</h2>
    </div>
    <div class="board">
        ${items.length > 0
        ? items.map(singleItemTemplate)
        : html`
            <div class="no-events">
                <p>This user has no events yet!</p>
            </div>`}
        
    </div>
</section>
`;

const singleItemTemplate = (item) => html`
<div class="eventBoard">
    <div class="event-info">
        <img src=${item.imageUrl}>
        <h2>${item.title}</h2>
        <h6>${item.date}</h6>
        <a href="/details/${item._id}" class="details-button">Details</a>
    </div>
</div>
`;

export async function profilePage(ctx) {

    const userData = getUserData(); 
    const items = await getProfileData(userData.id);

    ctx.render(profileTemplate(userData, items));
}