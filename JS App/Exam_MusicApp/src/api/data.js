import * as api from './api.js';

export const login = api.login;
export const logout = api.logout;
export const register = api.register;

const endpoints = {
    allData: '/data/albums?sortBy=_createdOn%20desc&distinct=name',
    itemsCollection: '/data/albums'
}

export function getAllData() {
    return api.get(endpoints.allData);
}

export function createItem(item) {
    return api.post(endpoints.itemsCollection, item);
}

export function getItemById(id) {
    return api.get(`${endpoints.itemsCollection}/${id}`);
}

export function deleteItemById(id) {
    return api.del(`${endpoints.itemsCollection}/${id}`);   
}

export function editItem(id, item) {
    return api.put(`${endpoints.itemsCollection}/${id}`, item);
}

export function getSearchItems(query) {
    return api.get(`/data/albums?where=name%20LIKE%20%22${query}%22`);
}
