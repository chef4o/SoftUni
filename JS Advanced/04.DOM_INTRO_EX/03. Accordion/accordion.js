function toggle() {
    const button = document.querySelector('.button');
    button.textContent = 
        button.textContent == 'More' 
                            ? 'Less' 
                            : 'More';

    const extraTextValue = document.querySelector('#extra');
    extraTextValue.style.display = 
        extraTextValue.style.display == 'block' 
                                      ? 'none' 
                                      : 'block';
}