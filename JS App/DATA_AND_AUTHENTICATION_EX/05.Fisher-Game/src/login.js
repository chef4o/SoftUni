const logoutBtn = document.querySelector('#user');
const loginBtn = document.querySelector('#user');
const welcomeMsg = document.querySelector('.email span');

window.addEventListener('DOMContentLoaded', () => {
    logoutBtn.style.display = 'none';
    const form = document.querySelector('form');
    form.addEventListener('submit', onLogin);
})

async function onLogin(ev) {
    ev.preventDefault();
    const formData = new FormData(ev.target);

    const email = formData.get('email');
    const password = formData.get('password');

    try {
        const res = await fetch('http://localhost:3030/users/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email, password })
        });
        if (res.ok != true) {
            const error = await res.json();
            throw new Error(error.message);
        }

        const data = await res.json();
        const userData = {
            email: data.email,
            id: data.id,
            token: data.token
        }
        sessionStorage.setItem('userData', JSON.stringify(userData));
        logoutBtn.style.display = 'inline-block';
        welcomeMsg.textContent = `${userData.email}`;
        window.location = './index.html';
        

    } catch (e) {
        alert(e.message);
    }



}