import { getItemById, editItem } from '../api/data.js';
import { getUserData } from '../util.js';
import { html } from '../lib.js';

const editTemplate = (item, onSubmit) => html`
<section class="editPage">
    <form @submit=${onSubmit}>
        <fieldset>
            <legend>Edit Album</legend>

            <div class="container">
                <label for="name" class="vhide">Album name</label>
                <input id="name" name="name" class="name" type="text" .value=${item.name}>

                <label for="imgUrl" class="vhide">Image Url</label>
                <input id="imgUrl" name="imgUrl" class="imgUrl" type="text" .value=${item.imgUrl}>

                <label for="price" class="vhide">Price</label>
                <input id="price" name="price" class="price" type="text" .value=${item.price}>

                <label for="releaseDate" class="vhide">Release date</label>
                <input id="releaseDate" name="releaseDate" class="releaseDate" type="text" .value=${item.releaseDate}>

                <label for="artist" class="vhide">Artist</label>
                <input id="artist" name="artist" class="artist" type="text" .value=${item.artist}>

                <label for="genre" class="vhide">Genre</label>
                <input id="genre" name="genre" class="genre" type="text" .value=${item.genre}>

                <label for="description" class="vhide">Description</label>
                <textarea name="description" class="description" rows="10" cols="10">${item.description}</textarea>

                <button href="/details/${item._id}" class="edit-album" type="submit">Edit Album</button>
            </div>
        </fieldset>
    </form>
</section>
`;

export async function editPage(ctx) {
    const item = await getItemById(ctx.params.id);

    const userData = getUserData();
    const isOwner = userData && userData.id == item._ownerId;

    if (isOwner) {
        ctx.render(editTemplate(item, onSubmit));

        async function onSubmit(ev) {
            ev.preventDefault();

            const formData = new FormData(ev.target);

            const name = formData.get('name').trim();
            const imgUrl = formData.get('imgUrl').trim();
            const price = formData.get('price').trim();
            const releaseDate = formData.get('releaseDate').trim();
            const artist = formData.get('artist').trim();
            const genre = formData.get('genre').trim();
            const description = formData.get('description').trim();

            if (name == '' || imgUrl == '' || price == '' || releaseDate == ''
                || artist == '' || genre == '' || description == '') {
                return alert('All fields are required');
            }

            await editItem(ctx.params.id, {
                name,
                imgUrl,
                price,
                releaseDate,
                artist,
                genre,
                description
            });

            ctx.page.redirect(`/details/${ctx.params.id}`);
        }
    }
}