(function () {
    Array.prototype.last = function () {
        return this[this.length - 1];
    }
    Array.prototype.skip = function (n) {
        const result = [];
        for (let index = n; index < this.length; index++) {
            result.push(this[index]);
        }
        return result;
    }
    Array.prototype.take = function (n) {
        const result = [];
        for (let index = 0; index < n; index++) {
            result.push(this[index]);
        }
        return result;
    }
    Array.prototype.sum = function () {
        return this.reduce((total, current) => total + Number(current), 0);
    }
    Array.prototype.average = function () {
        return this.reduce((total, current) => total + Number(current) / this.length, 0);
    }
})()

let arr = [1, 2, 3, 18];
console.log(arr.last());
console.log(arr.take(3));
console.log(arr.skip(2));
console.log(arr.sum());
console.log(arr.average());