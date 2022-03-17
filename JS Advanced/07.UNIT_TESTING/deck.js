function createDeck(deck) {

    try{
        console.log(deck
            .map(card => {
                const face = card.slice(0, card.length - 1);
                const suit = card.slice(-1);
                try {
                    return createCard(face, suit);
                } catch (err) {
                    throw new Error(`Invalid card: ${card}`);
                }
            })
            .join(' '));
    } catch (err) {
        console.log(err.message);
    }
    

    function createCard(face, suit) {
        const validFaces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A']
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
}

createDeck(['AS', '10D', 'KH', '2C']);
createDeck(['5S', '3D', 'QD', '1C']);