window.addEventListener('load', solve);

function solve() {

    const form = document.querySelector('form');
    document.querySelector('#add').addEventListener('click', onAdd);

    function onAdd(ev) {
        ev.preventDefault();
        const itemList = document.querySelector('#furniture-list');

        const model = form.querySelector('#model');
        const year = form.querySelector('#year');
        const description = form.querySelector('#description');
        const price = form.querySelector('#price');

        if (Number(year.value) && Number(price.value) && year.value > 0 && price.value > 0
            && model.value.trim() != "" && year.value.trim() != "" && description.value.trim() != "" && price.value.trim() != "") {

            const information = document.createElement('tr');
            information.className = 'info';
            information.innerHTML += `
            <td>${model.value.trim()}</td>
            <td>${Number(price.value.trim()).toFixed(2)}</td>
            <td> 
                <button class="moreBtn">More Info</button>
                <button class="buyBtn">Buy it</button>
            </td>`;
            information.querySelector('.moreBtn').addEventListener('click', onMore);
            information.querySelector('.buyBtn').addEventListener('click', onBuy);
            itemList.appendChild(information);
            const moreDetails = document.createElement('tr');
            moreDetails.className = 'hide';
            moreDetails.style.display = 'none';
            moreDetails.innerHTML += `
            <td>Year: ${year.value.trim()}</td>
            <td colspan="3">Description: ${description.value.trim()}</td>`;
            itemList.appendChild(moreDetails);
            model.value = '';
            year.value = '';
            description.value = '';
            price.value = '';

            function onMore(ev) {
                const btn = ev.target;
                const row = btn.parentNode.parentNode;
                const details = row.nextSibling;
                if (btn.textContent == 'More Info') {
                    btn.textContent = 'Less Info';
                    details.style.display = 'contents';
                } else {
                    btn.textContent = 'More Info';
                    details.style.display = 'none';
                }
            }

            function onBuy(ev) {
                const totalPrice = document.querySelector('.total-price');
                const row = ev.target.parentNode.parentNode;
                const currentPrice = row.querySelectorAll('td')[1].textContent;
                const details = row.nextSibling;
                totalPrice.textContent = (Number(totalPrice.textContent) + Number(currentPrice)).toFixed(2);

                itemList.removeChild(row);
                itemList.removeChild(details);
            }
        }
    }
}
