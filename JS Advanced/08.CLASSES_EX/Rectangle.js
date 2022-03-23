class Rectangle {
    constructor(a, b, color) {
        this.width = Number(a);
        this.height = Number(b);
        this.color = color;
    }

    calcArea = function() {
        return this.width * this.height;
    }
}

let rect = new Rectangle(4, 5, 'Red');
console.log(rect.width);
console.log(rect.height);
console.log(rect.color);
console.log(rect.calcArea());
