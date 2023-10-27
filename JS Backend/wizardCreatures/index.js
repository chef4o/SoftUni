const express = require("express");
const expressConfig = require("./config/expressConfig");
const databaseConfig = require("./config/databaseConfig");
const routesConfig = require("./config/routesConfig");
const {SERVER_PORT} = require('./local/env');

start();

async function start() {
  const app = express();

  await databaseConfig(app);

  expressConfig(app);
  routesConfig(app);

  app.listen(SERVER_PORT, () =>
    console.log(`Server listening on port ${SERVER_PORT}`)
  );
}
