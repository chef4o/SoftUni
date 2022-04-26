window.addEventListener('load', async () => {
    const form = document.querySelector('form');
    form.addEventListener('submit', onLogin);
});

async function onLogin(ev) {
    const url = `http://localhost:3030/users/login`;
    ev.preventDefault();
    const formData = new FormData(ev.target);
    const email = formData.get('email');
    const password = formData.get('password');

    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: { 
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({email, password})
        });
        if (response.ok != true) {
            const error = await response.json();
            throw new Error(error.message);
        }
        
        const data = await response.json();
        const token = data.accessToken;

        localStorage.setItem('token', token);
        window.location = './index.html';

    } catch (err) {
        alert(err.message);
    }
}