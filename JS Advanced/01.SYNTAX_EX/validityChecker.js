function validityCheck(x1, y1, x2, y2) {
    let p1 = [x1, y1];
    let p2 = [x2, y2];
    let p0 = [0, 0];

    let lineLendth = function([x1, y1], [x2, y2]) {
        let a = Math.abs(x1 - x2);
        let b = Math.abs(y1 - y2);
        let c = Math.sqrt(a**2 + b**2);
        let isValid = Number.isInteger(c) ? 'valid' : 'invalid';
        return `{${x1}, ${y1}} to {${x2}, ${y2}} is ${isValid}`;
    }
    
    console.log(lineLendth(p1, p0));
    console.log(lineLendth(p2, p0));
    console.log(lineLendth(p1, p2));
}

validityCheck(3, 0, 0, 4);
validityCheck(2, 1, 1, 1);