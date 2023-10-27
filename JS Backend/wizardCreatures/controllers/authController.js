const { register, login } = require("../services/authService");
const { parseError } = require("../util/parser");
const authController = require("express").Router();
const { SESSION_EXP_TIME_MS } = require("../local/env");
const { body, validationResult } = require("express-validator");

const PASSWORDS_MISMATCH = "Passwords do not match";
const MISSING_FIELDS_DATA = "All fields are required"

authController.get("/register", (req, res) => {
  res.render("register", {
    title: "Register page",
  });
});

authController.post("/register", async (req, res) => {
  body("firstName")
    .isLength({ min: 3 })
    .withMessage("First name should be at least 3 characters long");

  body("lastName")
    .isLength({ min: 3 })
    .withMessage("Last name should be at least 3 characters long");

  body("email")
    .isEmail()
    .withMessage("Email address is invalid")
    .isLength({ min: 10 })
    .withMessage("Email must be at least 10 characters long");

  try {
    const { errors } = validationResult(req);
    if (errors.length > 0) {
      throw errors;
    }

    if (req.body.password.length < 4) {
      throw new Error("Password must be at least 4 characters long");
    }

    if (req.body.password != req.body.rePass) {
      throw new Error(PASSWORDS_MISMATCH);
    }

    const token = await register(
      req.body.firstName,
      req.body.lastName,
      req.body.email,
      req.body.password
    );

    res.cookie("token", token, { maxAge: SESSION_EXP_TIME_MS });
    res.redirect("/");
  } catch (error) {
    err = parseError(error);
    console.log(err);
    res.render("register", {
      title: "Register page",
      body: req.body,
      errors: err,
    });
  }
});

authController.get("/login", (req, res) => {
  res.render("login", {
    title: "Login Page",
  });
});

authController.post("/login", async (req, res) => {
  body("email").isEmail().withMessage("Email address is invalid");

  try {
    const { errors } = validationResult(req);
    if (errors.length > 0) {
      throw errors;
    }

    if (req.body.password == "") {
      throw new Error(MISSING_FIELDS_DATA);
    }

    const token = await login(req.body.email, req.body.password);

    res.cookie("token", token, { maxAge: SESSION_EXP_TIME_MS });

    res.redirect("/");
  } catch (error) {
    const errors = parseError(error);

    res.render("login", {
      title: "Login Page",
      errors,
      body: req.body,
    });
  }
});

authController.get("/logout", (req, res) => {
  res.clearCookie("token");
  res.redirect("/");
});

module.exports = authController;
