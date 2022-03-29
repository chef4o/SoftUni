window.addEventListener('load', solve);

function solve() {
    const form = document.querySelector('form');
    form.addEventListener('submit', onSubmit);
    document.querySelector('#wrapper').addEventListener('click', onClick);

    function onSubmit(ev) {
        ev.preventDefault();
        const orders = document.querySelector('#received-orders');

        const data = ev.target;

        const type = data.querySelector('#type-product');
        const description = data.querySelector('#description');
        const name = data.querySelector('#client-name');
        const phone = data.querySelector('#client-phone');

        if ( type.value != '' && description.value.trim() != '' && name.value.trim() != '' && phone.value.trim() != '') {

            const orderElement = document.createElement('div');
            orderElement.className = 'container';
            orderElement.innerHTML = `
                <h2>Product type for repair: ${type.value.trim()}</h2>
                <h3>Client information: ${name.value.trim()}, ${phone.value.trim()}</h3>
                <h4>Description of the problem: ${description.value.trim()}</h4>
                <button class="start-btn">Start repair</button>
                <button class="finish-btn">Finish repair</button>`;
            const finishBth = orderElement.querySelector('.finish-btn');
            finishBth.disabled = true;

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
                    const [button1, button2] = orderToDelete.querySelectorAll('button');
                    orderToDelete.removeChild(button1);
                    orderToDelete.removeChild(button2);
                    completedOrders.appendChild(orderToDelete);
                    break;
                case 'clear-btn':
                    const element = document.createElement('selection');
                    element.id = "completed-orders";
                    element.innerHTML += `
                    <img src="./style/img/completed-order.png"></img>
                    <button class="clear-btn">Clear</button>`;

                    const allOrders = ev.target.parentNode.parentNode;
                    const allDeletedElements = allOrders.querySelector('#completed-orders');

                    allDeletedElements.remove();
                    allOrders.appendChild(element);
                    break;
            }
        }
    }
}