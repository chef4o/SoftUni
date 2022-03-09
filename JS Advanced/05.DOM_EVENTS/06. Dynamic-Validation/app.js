function validate() {
    document.getElementById('email').addEventListener('change', onClange);

    function onClange({target}) {
        const pattern = /^[\w]+@\w+.[a-z]+$/;
        if (!pattern.test(target.value)) {
            target.classList.add('error');
        } else {
            target.classList.remove('error');
        }   
    }
}