const authController = require("../controllers/authController");
const homeController = require("../controllers/homeController");
const catalogController = require("../controllers/catalogController");
const errorController = require("../controllers/errorController.js");
const profileController = require("../controllers/profileController");
const { hasUser, isGuest } = require("../middlewares/guards");

module.exports = (app) => {
    app.use('/', homeController);
    app.use('/auth', authController);
    app.use('/catalog', catalogController);
    app.use('/profile', profileController);
    app.use('*', errorController);
};