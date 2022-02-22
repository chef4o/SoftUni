function upperCase(text) {
    let output = [];
    let wordsExtract = text.split(/\W+/d);
    for (let word of wordsExtract) {
        if (word != '') {
            output.push(word.toUpperCase())
        }
    }
    console.log(output.join(', '));
}

upperCase('Hi, how are you?');