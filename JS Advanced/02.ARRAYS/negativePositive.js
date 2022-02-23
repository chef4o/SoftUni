function negPos(arr) {
    let output = [];
    for (const element of arr) {
        if (Number(element) < 0) {
            output.unshift(element);
        } else {
            output.push(element);
        }
    }
    return output;
}

console.log(negPos([7, -2, 8, 9]));
console.log(negPos([3, -2, 0, -1]));


