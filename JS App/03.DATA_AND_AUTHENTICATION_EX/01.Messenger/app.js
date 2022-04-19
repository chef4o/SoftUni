function attachEvents() {
    document.getElementById('refresh').addEventListener('click', loadMessages);
    document.getElementById('submit').addEventListener('click', submitMessage);

    loadMessages();
}
attachEvents();

const list = document.getElementById('messages');
const authorInput = document.querySelector('[name="author"]');
const contentInput = document.querySelector('[name="content"]');

async function submitMessage() {
    const author = authorInput.value;
    const content = contentInput.value;

    await createMessage({author, content});

    contentInput.value = '';
    list.value += `\n${author}: ${content}`;

}

async function loadMessages() {
    const url = `http://localhost:3030/jsonstore/messenger`;
    const result = await fetch(url);
    const data = await result.json();

    const messages = Object.values(data);

    list.value = messages.map(message => `${message.author}: ${message.content}`).join('\n');

}

async function createMessage (message) {
    const url = `http://localhost:3030/jsonstore/messenger`;
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(message)
    }

    const res = await fetch(url, options);
    const result = await res.json();
    return result;
}