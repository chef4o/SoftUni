const Creature = require("../models/entities/Creature");
const { getUserByEmail } = require("../services/userService");

async function getAllCreatures() {
  return await Creature.find({}).lean();
}

async function getCreatureById(id) {
  return await Creature.findOne({ _id: id }).lean().populate("author");
}

async function getCreaturesByAuthorId(authorId) {
  return await  Creature.find({author: authorId}).lean();
}

async function addCreature(
  name,
  species,
  skinColor,
  eyeColor,
  image,
  description,
  author
) {
  return await Creature.create({
    name,
    species,
    skinColor,
    eyeColor,
    image,
    description,
    author,
  });
}

async function vote(creatureId, userEmail) {
  const creature = await Creature.findOne({ _id: creatureId });

  if (!creature) {
    throw new Error("Creature not found");
  }

  const voter = await getUserByEmail(userEmail);
  if (voter == undefined) {
    throw new Error("User not found");
  }

  if (userHasVoted(creature, voter)) {
    throw new Error("User already voted");
  }

  if (!creature.voters.includes(voter._id)) {
    creature.voters.push(voter._id);
    await creature.save();
  }

  return creature;
}

async function userHasVoted(creature, user) {
  if (user == undefined) {
    return false;
  }
  const currentUser = await getUserByEmail(user.email);
  const voters = creature.voters.map((voterId) => voterId.toString());
  return voters.includes(currentUser._id.toString());
}

async function editCreature(
  creatureId,
  name,
  species,
  skinColor,
  eyeColor,
  image,
  description
) {

  const creature = await Creature.findOne({ _id: creatureId });

  creature.name = name;
  creature.species = species;
  creature.skinColor = skinColor;
  creature.eyeColor = eyeColor;
  creature.image = image;
  creature.description = description;

  await creature.save();
}

async function deleteCreature(creatureId) {
  await Creature.findByIdAndDelete(creatureId);
}

module.exports = {
  getAllCreatures,
  getCreatureById,
  getCreaturesByAuthorId,
  addCreature,
  editCreature,
  deleteCreature,
  vote,
  userHasVoted,
};
