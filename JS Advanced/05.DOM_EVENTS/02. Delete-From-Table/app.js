function deleteByEmail() {
    const clientDb = Array.from(document.querySelector('tbody').children);
    const inputField = document.querySelector('input[name="email"]');

    const rowsToDelete = clientDb.filter(client => client.children[1].textContent == inputField.value.trim());
    rowsToDelete.forEach(row => row.remove());

    document.getElementById('result').textContent = rowsToDelete.length > 0 ? 'Deleted' : 'Not found.';
}