const User = require("../models/entities/User");

const EXISTING_EMAIL =
  "The email address is already registered on this website.";
const GENERAL_LOGIN_ERROR = "The email or password is incorrect.";

function ensureUserExists(user, email, match) {
  if (!user || !match || user.email.toLowerCase() != email.toLowerCase()) {
    throw new Error(GENERAL_LOGIN_ERROR);
  }
}

async function ensureNewUser(email) {
  const existingUserWithEmail = await User.findOne({
    email: email.toLowerCase(),
  }).collation({
    locale: "en",
    strength: 2,
  });

  if (existingUserWithEmail) {
    throw new Error(EXISTING_EMAIL);
  }
}

async function getUserByEmail(email) {
  return await User.findOne({ email });
}

module.exports = {
  ensureUserExists,
  ensureNewUser,
  getUserByEmail,
};
