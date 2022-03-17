function subSum(arr, from, to) {

    if (!Array.isArray(arr)) {
        return NaN;
    }

    if (from < 0) {
        from = 0;
    }

    if (to > arr.length - 1) {
        to = arr.length - 1;
    }

    let sum = 0;
    for (let index = from; index <= to; index++) {
        sum += Number(arr[index]);
    }
    return sum;
}

console.log(subSum([10, 20, 30, 40, 50, 60], 3, 300));
console.log(subSum([1.1, 2.2, 3.3, 4.4, 5.5], -3, 1));
console.log(subSum([10, 'twenty', 30, 40], 0, 2));
console.log(subSum([], 1, 2));
console.log(subSum('text', 0, 2));