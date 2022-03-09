function attachGradientEvents() {
    const box = document.getElementById('gradient');
    box.addEventListener('mousemove', mouseMove);
    
    function mouseMove(ev) {
        const boxSize = ev.target.clientWidth;
        const gradientAmount = ev.offsetX / boxSize * 100.
        document.getElementById('result').textContent = `${Math.floor(gradientAmount)}%`;
    }
}