function extract(content) {
    const text = document.getElementById(content).textContent;
    const pattern = /\((.+?)\)/g;
    let output = '';

    let match = pattern.exec(text);
    while (match != null) {
        output += match[1] + '; ';
        match = pattern.exec(text);
    }

    console.log(output);
}