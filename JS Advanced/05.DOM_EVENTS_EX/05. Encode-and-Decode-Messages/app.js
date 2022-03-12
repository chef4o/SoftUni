function encodeAndDecodeMessages() {
    const [encodeBtn, decodeBtn] = Array.from(document.querySelectorAll('button'));
    encodeBtn.addEventListener('click', encode);
    decodeBtn.addEventListener('click', decode);
    const encodeBox = encodeBtn.parentElement.querySelector('textarea');
    const decoodeBox = decodeBtn.parentElement.querySelector('textarea');

    function encode(ev) {
        transmit(ev, 1, decoodeBox);
    }

    function decode(ev) {
        transmit(ev, -1, encodeBox);
    }

    //directions[encode: 1, decode: -1]
    function transmit(event, direction, destination) {
        const input = event.target.parentElement.querySelector('textarea');
        let output = destination;
        output.value = Array
            .from(input.value)
            .map(letter => String.fromCharCode(letter.charCodeAt(0) + direction))
            .join('');
        input.value = '';
    }
}