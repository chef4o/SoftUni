function equalNeighbour(matrix) {
    let equalPairs = 0;
    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            const element = matrix[row][col];
            const vComparator = row + 1 == matrix.length ? 'undefined' : matrix[row + 1][col];
            const hComparator = matrix[row][col + 1];
            if (element == hComparator && hComparator == vComparator) {
                equalPairs += 2;
            } else if (element == hComparator || element == vComparator) {
                equalPairs += 1;
            }
        }
    }
    return equalPairs;
}



equalNeighbour([['2', '2', '5', '7', '4'],
                ['4', '0', '5', '3', '4'],
                ['2', '5', '5', '4', '2']]);