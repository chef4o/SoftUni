function oddNums(arr) {
    let output = [];
    for (let index = 0; index < arr.length; index++) {
        if (index % 2 != 0) {
            output.push(arr[index] * 2);
        }
    }
    console.log(output.reverse()
                      .join(' '));
}

function oddNumsRe(arr) {
    return arr.filter((element, index) => index % 2 !== 0)
              .map(value => value * 2)
              .reverse()
              .join(' ');
}



oddNums([10, 15, 20, 25]);
oddNums([3, 0, 10, 4, 7, 3]);
console.log('-----');
console.log(oddNumsRe([10, 15, 20, 25]));
console.log(oddNumsRe([3, 0, 10, 4, 7, 3]));