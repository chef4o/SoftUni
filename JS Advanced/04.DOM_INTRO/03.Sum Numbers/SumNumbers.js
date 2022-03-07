function calc() {
    let result = Number(document.getElementById('num1').value)
        + Number(document.getElementById('num2').value);

    if (Number.isNaN(result)) {
        result = 'Please enter numbers only!';
    }

    document.getElementById('sum').value = result;
}