function biggerHalf(arr) {
    arr.sort((a, b) => a - b);
    return arr.slice(0 - (arr.length % 2 == 0 
                            ? arr.length / 2 
                            : Math.ceil(arr.length / 2)));  
}

console.log(biggerHalf([1, 5, 4, 2, 5]));
console.log(biggerHalf([3, 19, 14, 7, 2, 19, 6]));
