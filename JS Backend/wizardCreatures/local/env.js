const EnvData = {
  SERVER_PORT: 3000,
  DB_IP: "127.0.0.1",
  BKP_DB_IP: "0.0.0.0",
  DB_PORT: 27017,
  DB_SCHEMA: "wizard_creatures_wiki",
  TKN: "vwcvjrzut3mzbluf5ycnby48khrouw37",
  TKN_EXP_TIME: "1h",
  SESSION_EXP_TIME_MS: 3600000, //1h
};

Object.freeze(EnvData);

module.exports = EnvData;
