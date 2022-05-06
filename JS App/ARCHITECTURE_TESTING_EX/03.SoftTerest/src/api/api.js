const hostUri = 'http://localhost:3030';
const loginUri = '/users/login';
const registerUri = '/users/register';
const logoutUri = '/users/logout';

async function request(url, options) {
    try {
        const response = await fetch(hostUri + url, options);

        if (response.ok != true) {
            if (response.status == 403) {
                sessionStorage.removeItem('userData');
            }
            const error = await response.json();
            throw Error(error.message);
        }

        if (response.status == 204) {
            return response;
        } else {
            return response.json();
        }

    } catch (err) {
        alert(err.message);
        throw err;
    }
}

function createOptions(method = 'GET', data) {

    const options = {
        method,
        headers: {}
    };

    if (data != undefined) {
        options.headers['Content-Type'] = 'application/json';
        options.body = JSON.stringify(data);
    }

    const userData = JSON.parse(sessionStorage.getItem('userData'));
    if (userData != null) {
        options.headers['X-Authorization'] = userData.token;
    }

    return options;
}

export async function get(url) {
    return request(url, createOptions());
}

export async function post(url, data) {
    return request(url, createOptions('POST', data));
}

export async function put(url, data) {
    return request(url, createOptions('PUT', data));
}

export async function dlt(url) {
    return request(url, createOptions('DELETE'));
}

export async function login({ email, password }) {

    const result = await post(loginUri, { email, password });

    const userData = {
        email: result.email,
        id: result._id,
        token: result.accessToken
    };
    sessionStorage.setItem('userData', JSON.stringify(userData));
}

export async function register({ email, password }) {
    const result = await post(registerUri, { email, password });

    const userData = {
        email: result.email,
        id: result._id,
        token: result.accessToken
    };
    sessionStorage.setItem('userData', JSON.stringify(userData));
}

export async function logout() {
    await get(logoutUri);
    sessionStorage.removeItem('userData');
}

