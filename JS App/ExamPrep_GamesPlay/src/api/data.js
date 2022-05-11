import * as api from './api.js';

export const login = api.login;
export const logout = api.logout;
export const register = api.register;

const endpoints = {
    allData: '/data/games?sortBy=_createdOn%20desc',
    recentData: '/data/games?sortBy=_createdOn%20desc&distinct=category',
    itemsCollection: '/data/games', 
    allComments: '/data/comments'
}

export function getAllData() {
    return api.get(endpoints.allData);
}

export function getRecentData() {
    return api.get(endpoints.recentData);
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

export function getGameComments(gameId) {
    return api.get(`/data/comments?where=gameId%3D%22${gameId}%22`);
}

export function getAllComments() {
    return api.get(endpoints.allComments);
}

export function addComment(comment) {
    return api.post(endpoints.allComments, comment);
}