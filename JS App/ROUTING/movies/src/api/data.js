import * as api from './api.js';

const endpoints = {
    allMovies: '/data/movies'
}

export const register = api.register;
export const login = api.login;
export const logout = api.logout;   

export async function getAllMovies() {
    return api.get(endpoints.allMovies);
}

export async function getMovie(id) {
    return api.get(`${endpoints.allMovies}/${id}`);
}