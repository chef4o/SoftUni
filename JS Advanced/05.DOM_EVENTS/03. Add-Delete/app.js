function addItem() {

    const input = document.getElementById('newItemText');
    const li = document.createElement('li');
    li.textContent = input.value;
    document.getElementById('items').appendChild(li);
    input.value = '';

    const button = document.createElement('a');
    button.href = '#';
    button.textContent = '[Delete]';
    button.addEventListener('click', onClick);
    li.appendChild(button);

    function onClick(ev) {
        const liElement = ev.target.parentNode;
        liElement.remove();
    }

}