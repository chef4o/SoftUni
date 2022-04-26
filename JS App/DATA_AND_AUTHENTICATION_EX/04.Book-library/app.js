
const createForm = document.getElementById('createForm');
createForm.addEventListener('submit', onCreate);
const editForm = document.getElementById('editForm');
editForm.addEventListener('submit', onSave);
const tbody = document.querySelector('tbody');
tbody.addEventListener('click', onTablesClick);
document.getElementById('loadBooks').addEventListener('click', loadBooks);

loadBooks();

async function onSave(ev) {
    ev.preventDefault();
    const formData = new FormData(ev.target);

    const id = formData.get('id');
    const author = formData.get('author');
    const title = formData.get('title');

    await updateBook(id, { author, title });

    ev.target.reset();
    createForm.style.display = 'block';
    editForm.style.display = 'none';

    loadBooks();
}

async function onTablesClick(ev) {
    if (ev.target.className == 'delete') {
        onDelete(ev.target);
    } else if (ev.target.className == 'edit') {
        onEdit(ev.target);
    }
}

async function onEdit(button) {
    const id = button.parentNode.dataset.id;
    const book = await loadBookById(id); 

    createForm.style.display = 'none';
    editForm.style.display = 'block';

    editForm.querySelector('[name="author"]').value = book.author;
    editForm.querySelector('[name="title"]').value = book.title;
    editForm.querySelector('[name="id"]').value = id;
}

async function onDelete(button) {
     const id = button.parentNode.dataset.id;
     await deleteBook(id);
     button.parentNode.parentNode.remove();
}

async function onCreate(ev) {
    ev.preventDefault();
    const formData = new FormData(ev.target);

    const author = formData.get('author');
    const title = formData.get('title');

    const result = await createBook({ author, title });
    tbody.appendChild(createRow(result._id, result));
    ev.target.reset();
}

function createRow(id, book) {
    const row = document.createElement('tr');
    row.innerHTML = `<td>${book.title}</td>
    <td>${book.author}</td>
    <td data-id=${id}>
        <button class="edit">Edit</button>
        <button class="delete">Delete</button>
    </td>`;
    return row;
}
async function deleteBook(id) {
    const result = await request(`http://localhost:3030/jsonstore/collections/books/${id}`, {
        method: 'delete'
    });
    return result;
}

async function loadBooks() {
    const books = await request(`http://localhost:3030/jsonstore/collections/books`);
    const result = Object.entries(books).map(([id, book]) => createRow(id, book));
    tbody.replaceChildren(...result);
}

async function loadBookById(id) {
    const book = await request(`http://localhost:3030/jsonstore/collections/books/${id}`);
    return book;
}

async function updateBook(id, book) {
    const result = await request(`http://localhost:3030/jsonstore/collections/books/${id}`, {
        method: 'put',
        body: JSON.stringify(book)
    });
    return result;
}

async function createBook(book) {
    const result = await request(`http://localhost:3030/jsonstore/collections/books`, {
        method: 'post',
        body: JSON.stringify(book)
    });
    return result;
}

async function request(url, options) {
    if (options && options.body != undefined) {
        Object.assign(options, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
    }

    const response = await fetch(url, options);

    if (response.ok != true) {
        const error = await response.json();
        alert(error.message);
        throw new Error(error.message);
    }

    const data = await response.json();
    return data;
}