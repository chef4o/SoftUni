function smallestTwo(arr) {
    arr.sort((a, b) => a - b);
    return arr.slice(0, 2);
}

console.log(smallestTwo([30, 15, 50, 5]));
console.log(smallestTwo([3, 0, 10, 4, 7, 3]));