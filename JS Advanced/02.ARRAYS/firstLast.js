function firstLast(arr) {
    return Number(arr.shift()) +  Number(arr.pop());
}

console.log(firstLast(['20', '30', '40']));
console.log(firstLast(['5', '10']));
