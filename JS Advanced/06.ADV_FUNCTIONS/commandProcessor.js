function createProcessor() {
    let output = '';

    const result = {
        append,
        removeStart,
        removeEnd,
        print
    };

    return result;

    function append(word) {
        output += word;
        return result;
    }

    function removeStart(n) {
        output = output.slice(n);
        return result;
    }

    function removeEnd(n) {
        output = output.slice(0, -n);
        return result;
    }

    function print() {
        console.log(output);
        return result;
    }
}

let firstZeroTest = createProcessor().append('hello').append('again').removeStart(3).removeEnd(4).print();
