import { domElement, asyncDataFetch } from '../helpers.js';

async function accordion() {
    document.getElementById('main').replaceChildren();
    const main = document.getElementById('main');
    const articlesTitles = await asyncDataFetch('http://localhost:3030/jsonstore/advanced/articles/list');

    for await (const article of articlesTitles) {
        main.appendChild(createDom(article));
    }
    console.log(articlesTitles);
}   
accordion();

async function showMore(ev) {
    let buttonText = ev.target;
    const moreInfo = ev.target.parentNode.parentNode.querySelector('.extra p');

    if (moreInfo.parentNode.style.display == "none") {
        moreInfo.parentNode.style.display = "block";
        const articleId = ev.target.id;
        if (moreInfo.textContent == "") {
            moreInfo.textContent = 'Loading...'
            const details = await asyncDataFetch(`http://localhost:3030/jsonstore/advanced/articles/details/${articleId}`);
            moreInfo.textContent = details.content;
        }
        buttonText.textContent = 'Less';
    } else {
        moreInfo.parentNode.style.display = "none";
        buttonText.textContent = 'More';
    }
}

function createDom(article) {
    const element = domElement('div', {className: "accordion"});
        const head = domElement('div', {className: "head"});    
            head.appendChild(domElement('span', {}, `${article.title}`));
            const button = domElement('button', {className: "button", id: `${article._id}`}, "More");
            button.addEventListener('click', showMore);
            head.appendChild(button);
        element.appendChild(head);
        const moreInfo = domElement('div', {className: "extra"});    
            moreInfo.appendChild(domElement('p', {}));
        moreInfo.style.display = "none";
        element.appendChild(moreInfo);
    return element;
}
