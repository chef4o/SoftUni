async function loadRepos() {
	const username = document.getElementById('username').value;
	const repos = document.getElementById('repos');
	const url = `https://api.github.com/users/${username}/repos`;

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
		repos.innerHTML = '';

		data.forEach(repo => {
			const liElement = document.createElement('li');
			liElement.innerHTML = `<a href="${repo.html_url}">
	${repo.full_name}
</a>`;
			repos.appendChild(liElement);
		});
	}

	function handleError(error) {
		repos.innerHTML = '';
		repos.textContent = `${error.message}`;
	}
}