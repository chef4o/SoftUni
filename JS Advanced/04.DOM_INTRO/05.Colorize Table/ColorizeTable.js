function colorize() {
    const tableRows = document.querySelectorAll('table tr');
    for (let index = 1; index < tableRows.length; index += 2) {
        tableRows[index].style.backgroundColor = 'teal';
    }
}