function attachEvents() {
    document.getElementById('btnLoad').addEventListener('click', loadContacts);
    document.getElementById('btnCreate').addEventListener('click', onCreate);
    list.addEventListener('click', onDelete);
    loadContacts();

}

const list = document.getElementById('phonebook');
const personInput = document.getElementById('person');
const phoneInput = document.getElementById('phone');
attachEvents();

async function onDelete(ev) {
    const id = ev.target.dataset.id;
    if(id != undefined) {
        await deleteContact(id);
        ev.target.parentNode.remove();
    }
}

async function onCreate() {
    const person = personInput.value;
    const phone = phoneInput.value;
    const contact = { person, phone };

    const result = await createContact(contact);

    list.appendChild(createElement(result));
}

async function loadContacts() {
    const response = await fetch(`http://localhost:3030/jsonstore/phonebook`);
    const data = await response.json();

    list.replaceChildren(...Object.values(data).map(createElement));

}

function createElement(contact) {
    const liElement = document.createElement('li');
    liElement.innerHTML = `${contact.person}: ${contact.phone} <button data-id="${contact._id}">Delete</button>`;
    return liElement;
}

async function createContact(contact) {
    const response = await fetch(`http://localhost:3030/jsonstore/phonebook`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(contact)
    });

    const result = response.json();
    return result;
}

async function deleteContact(id) {
    const response = await fetch(`http://localhost:3030/jsonstore/phonebook/${id}`, {
        method: 'DELETE'
    });
    const result = await response.json();
    return result;
}