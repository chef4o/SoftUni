import { domElement, asyncDataFetch } from '../helpers.js';

window.addEventListener('DOMContentLoaded', lockedProfile);

async function lockedProfile() {
    document.getElementById('main').replaceChildren();
    const main = document.getElementById('main');
    const users = await asyncDataFetch('http://localhost:3030/jsonstore/advanced/profiles');

    let userId = 1;
    Object.values(users).forEach(user => main.appendChild(createDom(user, userId++)));
}  

function showMore(ev) {
    const isLocked = ev.target.parentNode.querySelector('[value="lock"]');
    const hiddenInfo = ev.target.parentNode.querySelector('[type="email"]').parentNode;
    if(!isLocked.checked) {
        switch(ev.target.textContent) {
            case 'Show more':
                hiddenInfo.style.display = "block";
                ev.target.textContent = 'Hide it';
                break;
            case 'Hide it': 
                hiddenInfo.style.display = "none";
                ev.target.textContent = 'Show more';
                break;
        }
    }
}

function createDom(user, id) {
    const element = domElement('div', {className: "profile"});
        element.appendChild(domElement('img', {src: "./iconProfile2.png", className: "userIcon"}));
        element.appendChild(domElement('label', {}, "Lock"));
        
        element.appendChild(domElement('input', {type: "radio", name: `user${id}Locked`, value: "lock", checked: true}));
        element.appendChild(domElement('label', {}, "Unlock"));
        element.appendChild(domElement('input', {type: "radio", name: `user${id}Locked`, value: "unlock"}));
        element.appendChild(domElement('br'));
        element.appendChild(domElement('hr'));
        element.appendChild(domElement('label', {}, "Username"));
        element.appendChild(domElement('input', {type: "text", name: `user${id}Username`, value: `${user.username}`, disabled: true, readonly: true}));
            const hiddenInfo = domElement('div', {id: `user${id}HiddenFields`});
            hiddenInfo.appendChild(domElement('hr', {}));
            hiddenInfo.appendChild(domElement('label', {}, "Email:"));
            hiddenInfo.appendChild(domElement('input', {type: "email", name: `user${id}Email`, value: `${user.email}`, disabled: true, readonly: true}));
            hiddenInfo.appendChild(domElement('label', {}, "Age"));
            hiddenInfo.appendChild(domElement('input', {type: "email", name: `user${id}Age`, value: `${user.age}`, disabled: true, readonly: "true"}));44
            hiddenInfo.style.display = "none";
            element.appendChild(hiddenInfo);
        const button = domElement('button', {}, "Show more");
        button.addEventListener('click', showMore);
        element.appendChild(button);
    return element;
}


