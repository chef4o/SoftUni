function getArticleGenerator(articles) {
    const arr = articles;
    const content = document.querySelector('#content');

    return () => {
        if (arr.length > 0) {
            const article = document.createElement('article');
            article.textContent = arr.shift();
            content.appendChild(article);
        }
    }
}
