const { getCreaturesByAuthorId } = require("../services/creatureService");
const { getUserByEmail } = require("../services/userService");

const profileController = require("express").Router();

profileController.get("/", async (req, res) => {
  try {
    const user = await getUserByEmail(req.user.email);
    const creatures = await getCreaturesByAuthorId(user._id);

    res.render("my-posts", {
      title: "Profile page",
      user,
      creatures,
    });
  } catch (error) {
    res.redirect("/auth/login");
  }
});

module.exports = profileController;
