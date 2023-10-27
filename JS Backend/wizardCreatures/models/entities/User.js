const {
  Schema,
  model,
  Types: { ObjectId },
} = require("mongoose");
const { isEmail } = require("validator");

const NAME_MIN_LENGTH = 3;
const EMAIL_MIN_LENGTH = 10;

const userSchema = new Schema({
  firstName: {
    type: String,
    required: true,
    minLength: [
      NAME_MIN_LENGTH,
      `First name must be at least ${NAME_MIN_LENGTH} characters long.`,
    ],
  },
  lastName: {
    type: String,
    required: true,
    minLength: [
      NAME_MIN_LENGTH,
      `Last name must be at least ${NAME_MIN_LENGTH} characters long.`,
    ],
  },
  email: {
    type: String,
    required: true,
    unique: true,
    validate: [isEmail, "The email address must be valid."],
    minLength: [
      EMAIL_MIN_LENGTH,
      `The email must be at least ${EMAIL_MIN_LENGTH} characters long.`,
    ],
  },
  hashedPassword: {
    type: String,
    required: true,
  },
});

userSchema.index(
  { email: 1 },
  {
    collection: {
      locale: "en",
      strength: 2,
    },
  }
);

const User = model("User", userSchema);

module.exports = User;
