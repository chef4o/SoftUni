function solve() {
    const infoField = document.querySelector('#info span');
    const departBtn = document.getElementById('depart');
    const arriveBtn = document.getElementById('arrive');
    let stop = {
        next: 'depot'
    }
    
    async function depart() {
        btnSwitcher(departBtn, arriveBtn);
        const url = `http://localhost:3030/jsonstore/bus/schedule/${stop.next}`;
        const response = await fetch(url);
        stop = await response.json(); 

        infoField.textContent = `Next stop ${stop.name}`;
    }

    function arrive() {
        btnSwitcher(arriveBtn, departBtn);
        infoField.textContent = `Arriving at ${stop.name}`;
    }

    return {
        depart,
        arrive
    };

    function btnSwitcher(activeBtn, inactiveBtn) {
        activeBtn.disabled = true;
        inactiveBtn.disabled = false;
    }
}

let result = solve();