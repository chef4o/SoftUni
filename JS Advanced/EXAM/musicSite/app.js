window.addEventListener('load', solve);

function solve() {
    const songsCollection = document.querySelector('.all-hits-container');
    const saveContainer = document.querySelector('.saved-container');
    const addBtn = document.querySelector('#add-btn');
    addBtn.addEventListener('click', addSong);

    function addSong(ev) {
        ev.preventDefault();
        const song = ev.target.parentElement;
        const genre = song.querySelector('#genre');
        const name = song.querySelector('#name');
        const author = song.querySelector('#author');
        const date = song.querySelector('#date');

        if (genre.value.trim() != ''
            && name.value.trim() != ''
            && author.value.trim() != ''
            && date.value.trim() != '') {

            const songElement = document.createElement('div');
            songElement.innerHTML += `
                <img src="./static/img/img.png">
                <h2>Genre: ${genre.value}</h2>
                <h2>Name: ${name.value}</h2>
                <h2>Author: ${author.value}</h2>
                <h3>Date: ${date.value}</h3>
                <button class="save-btn">Save song</button>
                <button class="like-btn">Like song</button>
                <button class="delete-btn">Delete</button>`;

            const saveBtn = songElement.querySelector('.save-btn');
            saveBtn.addEventListener('click', saveSong);
            const likeBtn = songElement.querySelector('.like-btn');
            likeBtn.addEventListener('click', likeSong);
            const deleteBtn = songElement.querySelector('.delete-btn');
            deleteBtn.addEventListener('click', deleteSong);
            songElement.className = "hits-info";
            songsCollection.appendChild(songElement);
        }
        genre.value = '';
        name.value = '';
        author.value = '';
        date.value = '';
    }

    function likeSong(ev) {
        const totalLikes = document.querySelector('.likes p');
        let likesContent = totalLikes.textContent.split(': ');
        totalLikes.textContent = `${likesContent[0]}: ${Number(likesContent[1]) + 1}`;
        ev.target.disabled = true;
    }

    function saveSong(ev) {
        const song = ev.target.parentElement;
        song.removeChild(song.querySelector('.save-btn'));
        song.removeChild(song.querySelector('.like-btn'));
        saveContainer.appendChild(song);
    }

    function deleteSong(ev) {
        const currentSong = ev.target.parentElement;
        const allSongs = currentSong.parentElement;
        allSongs.removeChild(currentSong);
    }
}
