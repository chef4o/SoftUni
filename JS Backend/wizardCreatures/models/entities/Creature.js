const {
  Schema,
  model,
  Types: { ObjectId },
} = require("mongoose");

const NAME_MIN_LENGTH = 2;
const SPECIES_MIN_LENGTH = 3;
const IMG_URL_PARRERN = /^https?:\/\//i;
const SKIN_COLOR_LENGTH = 3;
const EYE_COLOR_LENGTH = 3;
const DESCRIPTION_MIN_LENGTH = 5;
const DESCRIPTION_MAX_LENGTH = 500;

const creatureSchema = new Schema({
  name: {
    type: String,
    required: true,
    minLength: [
      NAME_MIN_LENGTH,
      `Name must be at least ${NAME_MIN_LENGTH} characters long.`,
    ],
  },
  species: {
    type: String,
    required: true,
    minLength: [
      SPECIES_MIN_LENGTH,
      `Species must be at least ${SPECIES_MIN_LENGTH} characters long.`,
    ],
  },
  skinColor: {
    type: String,
    required: true,
    minLength: [
      SKIN_COLOR_LENGTH,
      `The skin color must be at least ${SKIN_COLOR_LENGTH} characters long.`,
    ],
  },
  eyeColor: {
    type: String,
    required: true,
    minLength: [
      EYE_COLOR_LENGTH,
      `The eye color must be at least ${EYE_COLOR_LENGTH} characters long.`,
    ],
  },
  image: {
    type: String,
    required: true,
    match: [IMG_URL_PARRERN, "Image URL must start with 'http' or 'https'"],
  },
  description: {
    type: String,
    required: true,
    min: [
      DESCRIPTION_MIN_LENGTH,
      `The description must be at least ${DESCRIPTION_MIN_LENGTH} characters long.`,
    ],
    max: [
      DESCRIPTION_MAX_LENGTH,
      `The description must be less than ${DESCRIPTION_MAX_LENGTH} characters long.`,
    ],
  },
  voters: {
    type: [ObjectId],
    ref: "User",
  },
  author: {
    type: ObjectId,
    ref: "User",
  },
});

creatureSchema.index(
  { name: 1 },
  {
    collection: {
      locale: "en",
      strength: 2,
    },
  }
);

creatureSchema.virtual("votersEmails").get(function () {
  return this.voters.map((v) => v.email).join(", ");
});

const Creature = model("Creature", creatureSchema);

module.exports = Creature;
