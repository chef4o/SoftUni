import { cats } from './catSeeder.js';
import { html, render } from '../node_modules/lit-html/lit-html.js';

const catsTemplate = (kitties, onDetail) => html`
<ul>
    ${kitties.map(c => catBlock(c, onDetail))}
</ul>`

const catBlock = (cat, onDetail) => html`
<li>
    <img src="./images/${cat.imageLocation}.jpg" width="250" height="250" alt="Card image cap">
    <div class="info">
        <button class="showBtn" @click=${() => onDetail(cat)}>${cat.detail ? 'Hide status code' : 'Show status code'}</button>
        <div class="status" id=${cat.statusCode} style="display: ${cat.detail ? 'block' : 'none'}">
            <h4>Status Code: ${cat.statusCode}</h4>
            <p>${cat.statusMessage}</p>
        </div>
    </div>
</li>`

function start() {
    const allCatsView = document.getElementById('allCats');

    onRender();

    function onDetail(cat) {
        cat.detail = !cat.detail;
        onRender();
    }

    function onRender() {
        const result = catsTemplate(cats, onDetail);
        render(result, allCatsView);
    }
}
start();


