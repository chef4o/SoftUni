function findEven(arr) {
    let output = [];
    for (let index = 0; index < arr.length; index++) {
        if (index % 2 == 0) {
            output.push(arr[index]);
        }
    }
    console.log(output.join(' '));
}

findEven(['20', '30', '40', '50', '60']);