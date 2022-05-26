import { clearUserData, setUserData, getUserData } from '../util.js';

const host = 'http://localhost:3030';

async function asyncQuery(url, options) {
    try {
        const response = await fetch(host + url, options);
        if (response.ok != true) {
            if (response.status == 403) {
                clearUserData();
            }
            const error = await response.json();
            throw new Error(error.message);
        }
        return response.status == 204 ? response : response.json();
    } catch (error) {
        alert(error.message);
        throw new Error(error.message);
    }
}

async function get(url) {
    return asyncQuery(url, createOptions());
}

async function post(url, data) {
    return asyncQuery(url, createOptions('POST', data));
}

async function put(url, data) {
    return asyncQuery(url, createOptions('PUT', data));
}

async function dlt(url) {
    return asyncQuery(url, createOptions('DELETE'));
}

function createOptions(method = 'GET', data) {
    const options = {
        method: method,
        headers: {}
    };

    if (data != undefined) {
        options.headers['Content-Type'] = 'application/json';
        options.body = JSON.stringify(data);
    }

    const userData = getUserData();
    if (userData != null) {
        options.headers['X-Authorization'] = userData.token;
    }

    return options; 
}

async function login(email, password) {
    const response = await asyncQuery('/users/login', createOptions('POST', { email, password }));
    const userData = {
        email: response.email,
        id: response._id,
        token: response.accessToken
    };
    setUserData(userData);
}

async function register(email, password) {
    const response = await asyncQuery('/users/register', createOptions('POST', { email, password }));
    const userData = {
        email: response.email,
        id: response._id,
        token: response.accessToken
    };
    setUserData(userData);
}

async function logout() {
    await asyncQuery('/users/logout', createOptions());
    clearUserData();
}

export {
    get,
    post,
    put,
    dlt,
    login,
    logout,
    register
}