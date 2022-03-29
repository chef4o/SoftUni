window.addEventListener('load', solve);

function solve() {
    document.querySelector('form').addEventListener('submit', onSubmit);
    document.querySelector('#wrapper').addEventListener('click', onClick);

    function onSubmit(ev) {
        ev.preventDefault();
        const orders = document.querySelector('#received-orders');

        const data = ev.target;

        const type = data.querySelector('#type-product');
        const description = data.querySelector('#description');
        const name = data.querySelector('#client-name');
        const phone = data.querySelector('#client-phone');

        if (type.value != '' 
            && description.value.trim() != '' 
            && name.value.trim() != '' 
            && phone.value.trim() != '') {

            const orderElement = document.createElement('div');
            orderElement.className = 'container';
            orderElement.innerHTML = `
                <h2>Product type for repair: ${type.value.trim()}</h2>
                <h3>Client information: ${name.value.trim()}, ${phone.value.trim()}</h3>
                <h4>Description of the problem: ${description.value.trim()}</h4>
                <button class="start-btn">Start repair</button>
                <button class="finish-btn">Finish repair</button>`;
            orderElement.querySelector('.finish-btn').disabled = true;

            orders.appendChild(orderElement);

            type.value = '';
            description.value = '';
            name.value = '';
            phone.value = '';
        }
    }

    function onClick(ev) {
        if (ev.target.tagName == 'BUTTON') {
            switch (ev.target.className) {
                case 'start-btn':
                    console.log(ev.target.className)
                    const currentOrder = ev.target.parentNode;
                    currentOrder.querySelector('.start-btn').disabled = true;
                    currentOrder.querySelector('.finish-btn').disabled = false;
                    break;
                case 'finish-btn':
                    const completedOrders = document.querySelector('#completed-orders');
                    const orderToDelete = ev.target.parentNode;
                    orderToDelete.querySelectorAll('button').forEach(b => b.remove());
                    completedOrders.appendChild(orderToDelete);
                    break;
                case 'clear-btn':
                    const allOrders = ev.target.parentNode;
                    const allDeletedElements = allOrders.querySelectorAll('.container');
                    allDeletedElements.forEach(e => e.remove());
                    break;
            }
        }
    }
    
}