function diagonalsSum(array) {
    let output = [];
    let mainDiagonalSum = 0;
    let secDiagonalSum  = 0;
    for (let row = 0; row < array.length; row++) {
        mainDiagonalSum += Number(array[row][row]);
        secDiagonalSum += Number(array[row][array.length - 1 - row]);
    }
    output.push(mainDiagonalSum);
    output.push(secDiagonalSum);
    return output.join(' ');
}

console.log(diagonalsSum([[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]
   ));