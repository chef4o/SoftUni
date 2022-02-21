function sumOfNums(x, y) {
    let result = 0;
    for (let index = Number(x); index <= Number(y); index++) {
        result += index;
    }
    console.log(result);
} 

sumOfNums('1', '5');
sumOfNums('-8', '20');
