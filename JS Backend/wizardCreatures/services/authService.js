const User = require("../models/entities/User");
const {
  ensureUserExists,
  ensureNewUser,
} = require("./userService");

const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");
const { TKN, TKN_EXP_TIME } = require("../local/env");
const validator = require("validator");

const MISSING_MANDATORY_FIELDS_DATA = "All fields are required";
const INVALID_EMAIL = "Email address is invalid";

async function register(
  firstName,
  lastName,
  email,
  password,
) {

  await ensureNewUser(email);

  const hashedPassword = await bcrypt.hash(password, 10);

  const user = await User.create({
    firstName,
    lastName,
    email,
    hashedPassword,
  });

  return createSession({ email });
}

async function login(email, password) {
  validateFields(email, password);
  const user = await User.findOne({ email });

  const match = await bcrypt.compare(password, user.hashedPassword);

  ensureUserExists(user, email, match);
  return createSession(user);
}

function validateFields(...params) {
  params.forEach((param) => {
    const paramName = Object.keys(param)[0];
    const paramValue = param[paramName];

    if (
      !paramValue ||
      (typeof paramValue === "string" && paramValue.trim() === "")
    ) {
      console.log(`Parameter "${paramName}" is empty or not a string.`);
      throw new Error(MISSING_MANDATORY_FIELDS_DATA);
    }

    if (paramName === "email" && validator.isEmail(email) == false) {
      throw new Error(INVALID_EMAIL);
    }
  });
}

function createSession(user) {
  const payload = {
    email: user.email,
  };

  return jwt.sign(payload, TKN, {
    expiresIn: TKN_EXP_TIME,
  });
}

function verifyToken(token) {
  return jwt.verify(token, TKN);
}

module.exports = {
  register,
  login,
  verifyToken,
};
