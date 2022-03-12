function lockedProfile() {
    Array.from(document.querySelectorAll('.profile button'))
        .forEach(button => button.addEventListener('click', onToggle));

    function onToggle(ev) {
        const infoDif = Array.from(ev.target.parentElement.querySelectorAll('div'))
            .find(div => div.id.includes('HiddenFields'));
            
        const isActive = ev.target.parentElement
            .querySelector('input[type="radio"][value="unlock"]').checked;

        if (isActive) {
            if (ev.target.textContent == 'Show more') {
                ev.target.textContent = 'Hide it';
                infoDif.style.display = 'block';
            } else {
                ev.target.textContent = 'Show more';
                infoDif.style.display = '';
            }
        }
    }
}