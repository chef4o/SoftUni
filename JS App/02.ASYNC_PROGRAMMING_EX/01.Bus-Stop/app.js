async function getInfo() {

    const busStopInput = document.getElementById('stopId');
    const stopNameField = document.getElementById('stopName');
    const busesInfoField = document.getElementById('buses');
    const button = document.getElementById('submit');
    button.disabled = true;

    const url = getStopUrl('http://localhost:3030/jsonstore/bus/businfo/', busStopInput.value);
    try {
        stopNameField.textContent = `Loading...`;
        busesInfoField.textContent = '';

        const response = await fetch(url);
        button.disabled = true;
        
        if (response.status != 200) {
            throw new Error(`Buss stop ID ${busStopInput.value} not found`)
        }
        const data = await response.json();

        stopNameField.textContent = data.name;
        Object.entries(data.buses)
            .forEach(bus => {
                [id, arrvalTime] = bus;
                const busData = document.createElement('li');
                busData.textContent = `Bus ${id} arrives in ${arrvalTime} minutes`;
                busesInfoField.appendChild(busData);
            });

    } catch (error) {
        stopNameField.textContent = `Error`;
    }
    
    button.disabled = false;

    function getStopUrl(url, stopNumber) {
        return `${url}${stopNumber}`;
    }
}