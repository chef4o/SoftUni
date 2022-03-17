function createCards(face, suit) {
    const validFaces = ['2','3','4','5','6','7','8','9','10','J','Q','K','A']
    const suits = {
        'S': '\u2660',
        'H': '\u2665',
        'D': '\u2666',
        'C': '\u2663',
    }

    if (!validFaces.includes(face)) {
        throw new Error('Invalid face: ' + face);
    }

    if (!Object.keys(suits).includes(suit)) {
        throw new Error('Invalid suit: ' + suit);
    }

    return {
        face,
        suit: suits[suit],
        toString() {
            return this.face + this.suit;
        }
    }
}

try {
    const card1 = createCards('A', 'S');
    console.log(card1.toString());
    
    const card2 = createCards('10', 'H');
    console.log(card2.toString());
    
    const card3 = createCards('1', 'C');
    console.log(card3.toString());
    
    const card4 = createCards('2', 'Y');
    console.log(card4.toString());
    
} catch (err) {
    console.log(err);
}
