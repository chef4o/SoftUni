window.addEventListener('load', async () => {
    const form = document.querySelector('form');
    form.addEventListener('submit', onCreate);
});

async function onCreate(ev) {
    const url = `http://localhost:3030/data/recipes`;
    ev.preventDefault();

    const formData = new FormData(ev.target);

    const name = formData.get('name').trim();
    const img = formData.get('img').trim();
    const ingredients = formData.get('ingredients').trim().split('\n');
    const steps = formData.get('steps').trim().split('\n');

    const recipe = {
        name, img, ingredients, steps,
    }

    const token = localStorage.getItem('token');
    if (token == null) {
        window.location = './login.html';
        return;
    }

    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': token
            },
            body: JSON.stringify(recipe)
        })

        if (response.ok != true) {
            const error = await response.json();
            throw new Error(error.message);
        }
        
        await response.json();
        window.location = './index.html';

    } catch (err) {
        alert(err.message);
    }

}