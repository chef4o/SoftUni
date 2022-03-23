class Stringer {
    constructor(innerString, innerLength) {
        this.innerString = innerString;
        this.innerLength = innerLength;
    }

    increase(len) {
        this.innerLength += len;
    }

    decrease(len) {
        this.innerLength - len <= 0 
            ? this.innerLength = 0 
            : this.innerLength -= len;
    }

    toString() {
        return this.innerLength >= this.innerString.length
            ? this.innerString
            : `${this.innerString.substring(0, this.innerLength)}...`
    }
}


let test = new Stringer("Test", 5);
console.log(test.toString()); // Test

test.decrease(3);
console.log(test.toString()); // Te...

test.decrease(5);
console.log(test.toString()); // ...

test.increase(4); 
console.log(test.toString()); // Test
