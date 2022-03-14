function solve() {
    const [name, hall, ticketPrice] = document.querySelectorAll('#container input');
    const moviesSection = document.querySelector('#movies ul');
    const archiveSection = document.querySelector('#archive ul');
    const addMovieBtn = document.querySelector('#container button');   
    addMovieBtn.addEventListener('click', addMovie); 4
    const clearBtn = document.querySelector('#archive button');
    clearBtn.addEventListener('click', clearAll);

    function addMovie(ev) {
        ev.preventDefault();
        if (name.value != ''
            && hall.value != ''
            && ticketPrice.value != ''
            && Number(ticketPrice.value)) {

            const movieData = document.createElement('li');
            movieData.innerHTML += 
                `<span>${name.value}</span>
                 <strong>Hall: ${hall.value}</strong>
                 <div>
                    <strong>${Number(ticketPrice.value).toFixed(2)}</strong>
                    <input placeholder="Tickets Sold">
                    <button>Archive</button>
                 </div>`
            moviesSection.appendChild(movieData);

            const button = movieData.querySelector('div button');
            button.addEventListener('click', addToArchive);

            name.value = '';
            hall.value = '';
            ticketPrice.value = '';
        }
    }
    
    function addToArchive(ev) {
        const movieData = ev.target.parentElement.parentElement;
        const ticketsSold = movieData.querySelector('div input');
        const ticketPrice = movieData.querySelector('div strong');
        if (ticketsSold.value != '' && Number(ticketsSold.value)) {
            const income = Number(ticketsSold.value) * Number(ticketPrice.textContent);
            const movieName = movieData.querySelector('span');
            const structure = document.createElement('li');
            structure.innerHTML += 
                `<span>${movieName.textContent}</span>
                 <strong>Total amount: ${Number(income).toFixed(2)}</strong>
                 <button>Delete</button>`

            const deletBtn = structure.querySelector('button');
            deletBtn.addEventListener('click', deleteMovie);
            archiveSection.appendChild(structure);

            ev.target.parentElement.parentElement.remove();
        }
    }

    function deleteMovie(ev) {
        ev.target.parentElement.remove();
    }

    function clearAll(ev) {
        const archivedData = ev.target.parentElement.querySelector('ul');
        archivedData.innerHTML = '';
    }

}