class ArtGallery {

    constructor(creator) {
        this.creator = creator;
        this.possibleArticles = { "picture": 200, "photo": 50, "item": 250 };
        this.listOfArticles = [];
        this.guests = [];
    }

    addArticle(articleModel, articleName, quantity) {
        if (!this.possibleArticles[articleModel.toLocaleLowerCase()]) {
            throw Error("This article model is not included in this gallery!");
        }

        const article = this.listOfArticles.find(a => a.articleName.toLocaleLowerCase() == articleName.toLocaleLowerCase());

        article && article.articleModel.toLocaleLowerCase() == articleModel.toLocaleLowerCase()
            ? article.quantity += quantity
            : this.listOfArticles.push({ 
                "articleModel": articleModel, 
                "articleName": articleName, 
                "quantity": quantity 
            });

        return `Successfully added article ${articleName} with a new quantity- ${quantity}.`;
    }

    inviteGuest(guestName, personality) {
        if (this.guests.some(g => g.guestName.toLocaleLowerCase() == guestName.toLocaleLowerCase())) {
            throw Error(`${guestName} has already been invited.`);
        }

        let points = 50;
        if (personality.toLocaleLowerCase() == "vip") {
            points = 500;
        } else if (personality.toLocaleLowerCase() == "middle") {
            points = 250;
        }

        this.guests.push({
            "guestName": guestName,
            "points": points,
            "purchaseArticle": 0
        });

        return `You have successfully invited ${guestName}!`;
    }

    buyArticle(articleModel, articleName, guestName) {
        const article = this.listOfArticles.find(a => a.articleName.toLocaleLowerCase() == articleName.toLocaleLowerCase());
        if (!article || article.articleModel.toLocaleLowerCase() != articleModel) {
            throw Error(`This article is not found.`);
        }
        if (!article.quantity > 0) {
            throw Error(`The ${articleName} is not available.`)
        }

        const guest = this.guests.find(g => g.guestName.toLocaleLowerCase() == guestName.toLocaleLowerCase());
        if (!guest) {
            throw Error(`This guest is not invited.`);
        }

        const articlePoints = this.possibleArticles[articleModel.toLocaleLowerCase()]
        if (guest.points < articlePoints) {
            return "You need to more points to purchase the article.";
        } else {
            guest.points -= articlePoints;
            guest.purchaseArticle += 1;
            article.quantity -= 1;
        }

        return `${guestName} successfully purchased the article worth ${articlePoints} points.`
    }

    showGalleryInfo(criteria) {
        let output = [];
        switch (criteria.toLocaleLowerCase()) {
            case "article":
                output.push("Articles information:");
                this.listOfArticles.forEach(a => output.push(`${a.articleModel.toLocaleLowerCase()} - ${a.articleName} - ${a.quantity}`));
                break;
            case "guest":
                output.push("Guests information:");
                this.guests.forEach(g => output.push(`${g.guestName} - ${g.purchaseArticle}`));
                break;
        }

        return output.join("\n");
    }

}