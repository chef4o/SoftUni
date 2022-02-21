function circleArea(r) {

    let result;
    typeof(r) == 'number' 
                ? result = (Math.PI * Math.pow(r, 2)).toFixed(2)
                : result = `We can not calculate the circle area, because we receive a ${typeof(r)}.`;
    
    console.log(result);
}

circleArea(5);
circleArea('name');