function addItem() {
    const button = document.querySelector('input[type="button"]');
    button.addEventListener('click', add());

    function add(ev) {
        const [itemText, itemValue] = Array.from(document.querySelectorAll('input[type="text"]'));
        const menu = button.parentElement.querySelector('#menu');

        const option = document.createElement('option');
        option.textContent = itemText.value;
        option.value = itemValue.value;

        menu.appendChild(option);

        itemText.value = ''; 
        itemValue.value = '';
    }
}   