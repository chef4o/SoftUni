import { html } from '../lib.js';
import { getMovie } from '../api/data.js';

const editTemplate = (movie, onSubmit) => html`
<section id="edit-movie">
    <form @submit:${onSubmit} class="text-center border border-light p-5" action="#" method="">
        <h1>Edit Movie</h1>
        <div class="form-group">
            <label for="title">Movie Title</label>
            <input id="title" type="text" class="form-control" placeholder="Movie Title" .value=${movie.title} name="title">
        </div>
        <div class="form-group">
            <label for="description">Movie Description</label>
            <textarea class="form-control" placeholder="Movie Description..." name="description" .value=${movie.description}></textarea>
        </div>
        <div class="form-group">
            <label for="imageUrl">Image url</label>
            <input id="imageUrl" type="text" class="form-control" placeholder="Image Url" .value=${movie.img} name="imageUrl">
        </div>
        <button type="submit" class="btn btn-primary" >Submit</button>
    </form>
</section>`;

export async function editPage(ctx) {
    ctx.render(editTemplate(editMovie(ctx.params.id)));
};

async function editMovie(id) {
    const movie = await getMovie(id);

    return editTemplate(movie, onSubmit);

    async function onSubmit(ev) {
        movie.id;
    }

}

