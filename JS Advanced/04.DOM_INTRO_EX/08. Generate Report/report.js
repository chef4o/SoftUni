function generateReport() {
    const headers = Array.from(document.querySelectorAll('input[type = "checkbox"]'));
    const table = Array.from(document.querySelectorAll('table tbody tr'));
    const output = [];

    const checkedCols = [];
    for (let index = 0; index < headers.length; index++) {
        if (headers[index].checked) {
            checkedCols.push({
                colIndex: index,
                colName: headers[index].name
            });
        }
    }
    const colNames = checkedCols.map(e => e.columnName);

    table.forEach(row => {
        const obj = {};
        for (const element of checkedCols) {
            obj[element.colName] = row.children[element.colIndex].textContent;
        }
        output.push(obj);
    });

    document.querySelector('#output').value = JSON.stringify(output, null, 2);
}