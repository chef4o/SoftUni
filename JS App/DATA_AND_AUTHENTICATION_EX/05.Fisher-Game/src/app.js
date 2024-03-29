let userData = null;

window.addEventListener('DOMContentLoaded', () => {
    userData = JSON.parse(sessionStorage.getItem('userData'));
    const welcomeMsg = document.querySelector('.email span');

    if (userData != null) {
        document.getElementById('guest').style.display = 'none';
        document.querySelector('#addForm .add').disabled = false;
        welcomeMsg.textContent = `${userData.email}`;
    } else {
        document.getElementById('user').style.display = 'none';
    }

    document.querySelector('.load').addEventListener('click', loadData);
    document.getElementById('addForm').addEventListener('submit', onCreateSubmit);
})

async function onCreateSubmit(ev) {
    ev.preventDefault();
    const formData = new FormData(ev.target);

    const data = [...formData.entries()].reduce((acc, entry) => Object.assign(acc, { [entry[0]]: entry[1] }), {});
    try {
        if (Object.values(data).some(x => x == '')) {
            throw new Error(`All fieleds are required`);
        }
        const res = await fetch('http://localhost:3030/data/catches/', {
            methot: "post",
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': userData.token
            },
            body: JSON.stringify(data)
        })

        ev.target.reset();
        loadData();

    } catch (e) {
        alert(e.message);
    }
}

async function loadData() {
    const res = await fetch('http://localhost:3030/data/catches/');
    const data = await res.json();

    document.getElementById('catches').replaceChildren(...data.map(createPreview))
}

function createPreview(item) {
    const isOwner = (userData && item._ownerId == userData.id);
    const element = document.createElement('div');
    element.className = 'catch';
    element.innerHTML = `<label>Angler</label>
<input type="text" class="angler" value="${item.angler}" ${!isOwner ? 'disabled' : ''}>
<label>Weight</label>
<input type="text" class="weight" value="${item.weight}"${!isOwner ? 'disabled' : ''}>
<label>Species</label>
<input type="text" class="species" value="${item.species}"${!isOwner ? 'disabled' : ''}>
<label>Location</label>
<input type="text" class="location" value="${item.location}"${!isOwner ? 'disabled' : ''}>
<label>Bait</label>
<input type="text" class="bait" value="${item.bait}"${!isOwner ? 'disabled' : ''}>
<label>Capture Time</label>
<input type="number" class="captureTime" value="${item.captureTime}"${!isOwner ? 'disabled' : ''}>
<button class="update" data-id="07f260f4-466c-4607-9a33-f7273b24f1b4" ${!isOwner ? 'disabled' : ''}>Update</button>
<button class="delete" data-id="07f260f4-466c-4607-9a33-f7273b24f1b4" ${!isOwner ? 'disabled' : ''}>Delete</button>`;
    return element;
}