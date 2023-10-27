const homeController = require("express").Router();

homeController.get("/", async (req, res) => {
  res.render("home", {
    title: "Home page",
    user: req.user,
  });
});

module.exports = homeController;
