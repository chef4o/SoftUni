function parseError(error) {
  if (error.name == "ValidationError") {
    //parsing errors from mongoose
    return Object.values(error.errors).map((v) => v.message);
  } else if (Array.isArray(error)) {
    return error.map((e) => e.msg);
  }
  return error.message.split("\n");
}

module.exports = {
  parseError,
};
