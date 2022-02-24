function printElement(array, n) {
    return array.filter((v, i) => i % n == 0);
}

console.log(printElement(['5', 
'20', 
'31', 
'4', 
'20'], 
2
));

console.log(printElement(['1', 
'2',
'3', 
'4', 
'5'], 
6
));

console.log(printElement(['dsa',
'asd', 
'test', 
'tset'], 
2
))