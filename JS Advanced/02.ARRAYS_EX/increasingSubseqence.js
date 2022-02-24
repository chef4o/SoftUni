function subsequence(array) {
    let maxNum = Number.MIN_SAFE_INTEGER;
    let output = [];
    array.forEach(element => {
        if (element >= maxNum) {
            output.push(element);
            maxNum = element;
        }
    });
    return output;
}

// option 2
function subsequenceRe(array) {
    let max = Number.MIN_SAFE_INTEGER;
    const output = array.filter((element) => {
        if (element >= max) {
            max = element;
            return true;
        } else {
            return false;
        }
    });
    return output;
}

// option 3
function subsequenceRe2(array) {
    let max = Number.MIN_SAFE_INTEGER;
    const output = [];
    array.reduce((accumulator, current) => {
        if (current >= max) {
            accumulator.push(current);
            max = current;
        }
        return accumulator;
    }, output)
    return output;
}

console.log(subsequence([1, 
    3, 
    8, 
    4, 
    10, 
    12, 
    3, 
    2, 
    24]
    ));

console.log(subsequenceRe([1, 
    3, 
    8, 
    4, 
    10, 
    12, 
    3, 
    2, 
    24]
    ));

console.log(subsequenceRe2([1, 
    3, 
    8, 
    4, 
    10, 
    12, 
    3, 
    2, 
    24]
    ));