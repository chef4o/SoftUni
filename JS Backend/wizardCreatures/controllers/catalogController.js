const { body, validationResult } = require("express-validator");
const { parseError } = require("../util/parser");
const { getUserByEmail } = require("../services/userService");

const {
  getAllCreatures,
  getCreatureById,
  addCreature,
  editCreature,
  deleteCreature,
  vote,
  userHasVoted,
} = require("../services/creatureService");

const catalogController = require("express").Router();

catalogController.get("/", async (req, res) => {
  const creatures = await getAllCreatures();

  res.render("all-posts", {
    title: "Catalog page",
    user: req.user,
    creatures,
  });
});

catalogController.get("/creatures/create", async (req, res) => {
  res.render("create", {
    title: "Create a post",
    user: req.user,
  });
});

catalogController.post("/creatures/create", async (req, res) => {
  body("name")
    .isLength({ min: 2 })
    .withMessage("Name should be at least 2 characters long");

  body("species")
    .isLength({ min: 3 })
    .withMessage("Species should be at least 3 characters long");

  body("skinColor")
    .isLength({ min: 2 })
    .withMessage("Skin color should be at least 3 characters long");

  body("eyeColor")
    .isLength({ min: 3 })
    .withMessage("Eye color should be at least 3 characters long");

  body("image").isURL().withMessage("URL is invalid");

  body("description")
    .isLength({ min: 5, max: 500 })
    .withMessage("Description should be between 5 and 500 characters long");

  try {
    const { errors } = validationResult(req);
    if (errors.length > 0) {
      throw errors;
    }

    const author = await getUserByEmail(req.user.email);

    await addCreature(
      req.body.name,
      req.body.species,
      req.body.skinColor,
      req.body.eyeColor,
      req.body.image,
      req.body.description,
      author
    );

    res.redirect("/");
  } catch (error) {
    err = parseError(error);

    res.render("create", {
      title: "Create a creature",
      body: req.body,
      errors: err,
    });
  }
});

catalogController.get("/creatures/details/:id", async (req, res) => {
  const creature = await getCreatureById(req.params.id);
  const isAuthor = checkIfAuthor(creature.author, req.user);
  const hasVoted = await userHasVoted(creature, req.user);

  res.render("details", {
    title: "Catalog page",
    user: req.user,
    creature,
    isAuthor,
    hasVoted,
  });
});

catalogController.get("/creatures/vote/:id", async (req, res) => {
  const creatureId = req.params.id;
  const voterEmail = req.user != undefined ? req.user.email : undefined;

  try {
    if (voterEmail != undefined && !req.hasVoted) {
      await vote(creatureId, voterEmail);
    }
    
    res.redirect(`/catalog/creatures/details/${req.params.id}`);
  } catch (error) {
    err = parseError(error);

    res.redirect(`/catalog/creatures/details/${req.params.id}`);
  }
});

catalogController.get("/creatures/edit/:id", async (req, res) => {
  try {
    const creature = await getCreatureById(req.params.id);
    const isAuthor = checkIfAuthor(creature.author, req.user);
    if (!isAuthor) {
      throw new Error("Only authors can edit");
    }

    res.render("edit", {
      title: "Edit a post",
      user: req.user,
      creature,
      isAuthor,
    });
  } catch (error) {
    err = parseError(error);

    const creature = await getCreatureById(req.params.id);

    res.render("details", {
      title: "Catalog page",
      user: req.user,
      creature,
      errors: err,
    });
  }
});

catalogController.post("/creatures/edit/:id", async (req, res) => {
  body("name")
    .isLength({ min: 2 })
    .withMessage("Name should be at least 2 characters long");

  body("species")
    .isLength({ min: 3 })
    .withMessage("Species should be at least 3 characters long");

  body("skinColor")
    .isLength({ min: 2 })
    .withMessage("Skin color should be at least 3 characters long");

  body("eyeColor")
    .isLength({ min: 3 })
    .withMessage("Eye color should be at least 3 characters long");

  body("image").isURL().withMessage("URL is invalid");

  body("description")
    .isLength({ min: 5, max: 500 })
    .withMessage("Description should be between 5 and 500 characters long");

  try {
    const { errors } = validationResult(req);
    if (errors.length > 0) {
      throw errors;
    }

    const creature = await getCreatureById(req.params.id);

    const isAuthor = checkIfAuthor(creature.author, req.user);
    if (!isAuthor) {
      throw new Error("Only authors can edit");
    }

    await editCreature(
      req.params.id,
      req.body.name,
      req.body.species,
      req.body.skinColor,
      req.body.eyeColor,
      req.body.image,
      req.body.description
    );

    res.redirect(`/catalog/creatures/details/${req.params.id}`);
  } catch (error) {
    err = parseError(error);

    const creature = await getCreatureById(req.params.id);
    const isAuthor = checkIfAuthor(creature.author, req.user);

    res.render("edit", {
      title: "Edit a creature",
      body: req.body,
      creature,
      errors: err,
      isAuthor,
    });
  }
});

catalogController.get("/creatures/delete/:id", async (req, res) => {
  try {
    const creature = await getCreatureById(req.params.id);
    const isAuthor = checkIfAuthor(creature.author, req.user);
    if (!isAuthor) {
      throw new Error("Only the author can delete");
    }

    await deleteCreature(req.params.id);

    res.redirect("/catalog/");
  } catch (error) {
    err = parseError(error);

    const creature = await getCreatureById(req.params.id);
    const isAuthor = checkIfAuthor(creature.author, req.user);

    res.render("details", {
      title: "Catalog page",
      user: req.user,
      creature,
      errors: err,
      isAuthor,
    });
  }
});

function checkIfAuthor(author, user) {
  return author != undefined && user != undefined && author.email == user.email;
}

module.exports = catalogController;
