function solve() {
  const table = document.querySelector('table.table tbody');
  const [inputField, outputField] = Array.from(document.querySelectorAll('textarea'));
  const [generateButton, buyButton] = Array.from(document.querySelectorAll('button'));

  generateButton.addEventListener('click', generate);
  buyButton.addEventListener('click', buy);

  function generate(ev) {
    const data = JSON.parse(inputField.value);

    for (const item of data) {
      const row = document.createElement('tr');

      row.appendChild(generateCell('img', { src: item.img }));
      row.appendChild(generateCell('p', {}, item.name));
      row.appendChild(generateCell('p', {}, item.price));
      row.appendChild(generateCell('p', {}, item.decFactor));
      row.appendChild(generateCell('input', { type: 'checkbox' }));

      table.appendChild(row);
    }

    document.querySelectorAll('input[type="checkbox"]')
      .forEach(c => c.disabled = false);

  }

  function generateCell(nestedTag, properties, content) {
    const cell = document.createElement('td');
    const nested = document.createElement(nestedTag);

    for (const property in properties) {
      nested[property] = properties[property];
    }

    if (content) {
      nested.textContent = content;
    }

    cell.appendChild(nested);
    return cell;
  }

  function buy(ev) {

    const furnitures = Array.from(document.querySelectorAll('.table input[type="checkbox"]:checked'))
      .map(chkBox => chkBox.parentElement.parentElement)
      .map(row => ({
        name: row.children[1].textContent,
        price: Number(row.children[2].textContent),
        decFactor: Number(row.children[3].textContent)
      }));

    const names = furnitures.map(e => e.name.trim());
    const total = furnitures.reduce((t, c) => t + c.price, 0);
    const avgDecFactor = furnitures.reduce((t, c) => t + c.decFactor, 0) / furnitures.length;
    
    const result = `Bought furniture: ${names.join(', ')}
Total price: ${total.toFixed(2)}
Average decoration factor: ${avgDecFactor}`

    outputField.value = result;
  }
}