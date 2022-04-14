function attachEvents() {
    document.getElementById('btnLoadPosts').addEventListener('click', getAllPosts);
    document.getElementById('btnViewPost').addEventListener('click', displayPost);
}
attachEvents();

async function displayPost() {
    const postTitle = document.getElementById('post-title');
    const postBody = document.getElementById('post-body');
    const postComments = document.getElementById('post-comments');
    postTitle.textContent = 'Loading...';
    postBody.textContent = '';
    postComments.replaceChildren();

    const selectedId = document.getElementById('posts').value;
    const[post, comments] = await Promise.all([
        getPostById(selectedId),
        getCommentsByPostId(selectedId)
    ]);

    postTitle.textContent = post.title;
    postBody.textContent = post.body;

    Object.values(comments).forEach(comment => {
        const element = document.createElement('li');
        element.id = comment.id;
        element.textContent = comment.text;
        postComments.appendChild(element);
    });
    console.log(post, comments);
}

async function getAllPosts() {
    const data = await asyncDataFetch(`http://localhost:3030/jsonstore/blog/posts`);
    const posts = document.getElementById('posts');
    posts.replaceChildren();

    Object.values(data).forEach(post => {
        const element = document.createElement('option');
        element.textContent = post.title;
        element.value = post.id;
        posts.appendChild(element);
    });
}

async function getPostById(id) {
    return await asyncDataFetch(`http://localhost:3030/jsonstore/blog/posts/${id}`);
}

async function getCommentsByPostId(postId) {
    const data = await asyncDataFetch(`http://localhost:3030/jsonstore/blog/comments`);
    return Object.values(data).filter(comment => comment.postId == postId);
}

async function asyncDataFetch(url) {
    const result = await fetch(url);
    return result.json();
}


