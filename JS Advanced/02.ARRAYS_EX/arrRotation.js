function rotateArr(arr, rotations) {
    while(rotations-- > 0) {
        arr.unshift(arr.pop());
    }
    console.log(arr.join(' '));
}

rotateArr(['1', 
'2', 
'3', 
'4'], 
2
);
rotateArr(['Banana', 
'Orange', 
'Coconut', 
'Apple'], 
15
);

