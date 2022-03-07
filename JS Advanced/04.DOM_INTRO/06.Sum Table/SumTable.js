function sumTable() {
    const table = document.querySelectorAll('table tr');
    let sum = 0;
    for (let row = 1; row < table.length - 1; row++) {
        const price = Number(table[row].lastElementChild.textContent);
        sum += price;
    }
    document.getElementById('sum').textContent = sum;
}