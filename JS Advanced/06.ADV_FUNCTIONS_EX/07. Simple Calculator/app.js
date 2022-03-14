function calculator() {
    let numOne;
    let numTwo;
    let resultBox;

    function init (param1, param2, param3) {
        numOne = document.querySelector(param1);
        numTwo = document.querySelector(param2);
        resultBox = document.querySelector(param3);
    }

    function add() {
        resultBox.value = Number(numOne.value) + Number(numTwo.value);
    }

    function subtract() {
        resultBox.value = Number(numOne.value) - Number(numTwo.value);
    }

    return {
        init,
        add,
        subtract
    }
}

const calculate = calculator (); 
calculate.init ('#num1', '#num2', '#result'); 





