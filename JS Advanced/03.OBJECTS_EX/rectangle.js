function rectangle(x, y, color) {
    return {
        width: Number(x),
        height: Number(y),
        color: color.charAt(0).toUpperCase() + color.slice(1),
        calcArea: function() { return this.width * this.height } 
    }
}

let rect = rectangle(4, 5, 'red');
console.log(rect.width);
console.log(rect.height);
console.log(rect.color);
console.log(rect.calcArea());
