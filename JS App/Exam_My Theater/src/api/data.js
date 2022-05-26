import * as api from './api.js';

export const login = api.login;
export const logout = api.logout;
export const register = api.register;

const endpoints = {
    allData: '/data/theaters?sortBy=_createdOn%20desc&distinct=title',
    itemsCollection: '/data/theaters', 
    likes: '/data/likes'
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

export function getProfileData(userId) {
    return api.get(`/data/theaters?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);
}

export function likeItem(theaterId) {
    return api.post(endpoints.likes, theaterId);
}

export function getLikeDataByMovie(theaterId) {
    return api.get(`/data/likes?where=theaterId%3D%22${theaterId}%22&distinct=_ownerId&count`);
}

export function getLikeDataByUser(theaterId, userId) {
    return api.get(`/data/likes?where=theaterId%3D%22${theaterId}%22%20and%20_ownerId%3D%22${userId}%22&count`);
}