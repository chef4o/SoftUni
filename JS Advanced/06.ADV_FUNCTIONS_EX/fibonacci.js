function getFibonacci() {
    let x = 0;
    let y = 1;
    function getNumber() {
        let nextNum = x + y;
        x = y;
        y = nextNum;
        return x;
    }
    return getNumber;
}

let fib = getFibonacci();
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());