function sum(num) {
    let sum = num;

    function add(num2) {
        sum += num2;
        return add;
    }

    add.toString = () => sum;
    return add;
}

console.log(sum(4)(3).toString());