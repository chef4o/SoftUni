function sameNums(numbers) {
    
    let stringInput = numbers.toString();
    let sum = Number(stringInput[0]);
    let isEqual = true;

    for (let index = 1; index < stringInput.length; index++) {
        sum += Number(stringInput[index]);
        if (isEqual 
            && stringInput[index] != stringInput[index - 1]) {
            isEqual = false;
        }
    }
    console.log(`${isEqual}\n${sum}`);
}

sameNums(22222222);