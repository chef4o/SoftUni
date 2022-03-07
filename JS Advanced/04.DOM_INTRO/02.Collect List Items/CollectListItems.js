function extractText() {
    const items = document.getElementById('items').children;
    const output = [];
    for (const item of Array.from(items)) {
        output.push(item.textContent);
    }
    document.getElementById('result').textContent = output.join('\n');
}