function starSquare(n) {

    let stars;
    typeof(n) === 'undefined' 
                ? stars = 5
                : stars = n;
    
    for (let row = 0; row < stars; row++) {
        let starsImg  = '';
        for (let col = 0; col < stars; col++) {
            starsImg += '* ';
        }
        console.log(starsImg);
    }
}

starSquare(1);
starSquare(2);
starSquare(3);
starSquare(4);
starSquare();