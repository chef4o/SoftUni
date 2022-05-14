import * as api from './api.js';

export const login = api.login;
export const logout = api.logout;
export const register = api.register;

const endpoints = {
    allData: '/data/memes?sortBy=_createdOn%20desc',
    itemsCollection: '/data/memes'
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
    return api.dlt(`${endpoints.itemsCollection}/${id}`);   
}

export function editItem(id, item) {
    return api.put(`${endpoints.itemsCollection}/${id}`, item);
}

export function getUserItems(user_id) {
    return api.get(`/data/memes?where=_ownerId%3D%22${user_id}%22&sortBy=_createdOn%20desc`);
}