function magicMatrictes(matrix) {
    let isMagical = true;
    let sum = function (array) {
        return array.reduce((a, b) => a + b, 0);
    }
    for (let row = 0; row < matrix.length - 1; row++) {
        if (sum(matrix[row]) != sum(matrix[row + 1])) {
            isMagical = false;
            break;
        }
    }
    if (isMagical) {
        for (let column = 0; column < matrix.length; column++) {
            const currentCol = [];
            for (let row = 0; row < matrix.length; row++) {
                currentCol.push(matrix[row][column]);
            }
            if (sum(currentCol) != sum(matrix[column])) {
                isMagical = false;
                break;
            }
        }
    }
    console.log(isMagical);
}

magicMatrictes([[4, 5, 6],
[6, 5, 4],
[5, 5, 5]]
);

magicMatrictes([[11, 32, 45],
[21, 0, 1],
[21, 1, 1]]
);

magicMatrictes([[1, 0, 0],
[0, 0, 1],
[0, 1, 0]]
);
