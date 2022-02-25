function createRecord(name, population, treasury) {
    const city = {};
    city.name = name;
    city.population = population;
    city.treasury = treasury;
    return city;
}

createRecord('Tortuga',
    7000,
    15000
);

createRecord('Santo Domingo',
    12000,
    23500
);