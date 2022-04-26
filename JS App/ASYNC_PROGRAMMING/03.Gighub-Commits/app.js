async function loadCommits() {
    const username = document.getElementById('username').value;
    const repo = document.getElementById('repo').value;
    const commits = document.getElementById('commits');
    const url = `https://api.github.com/repos/${username}/${repo}/commits`;

    const response = await fetch(url);

    try {
        if (response.ok == false) {
            throw new Error(`${response.status} ${response.statusText}`);
        }

        const data = await response.json();
        handleResponse(data);
    } catch (err) {
        handleError(err);
    }

    function handleResponse(data) {
        commits.innerHTML = '';

        data.forEach(r => {
            const liElement = document.createElement('li');
            liElement.innerHTML = `<a href="${r.html_url}">
        ${r.sha}
    </a>`;
            commits.appendChild(liElement);
        });
    }

    function handleError(error) {
        commits.innerHTML = '';
        commits.textContent = `${error.message}`;
    }

}