const errorController = require("express").Router();

errorController.get("/", (req, res) => {
  res.render("404", {
    title: "Not found page",
  });
});

module.exports = errorController;
