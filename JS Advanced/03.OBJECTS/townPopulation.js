function townPopulation(input) {
    const towns = {};
    for (const row of input) {
        const dataEntry = row.split(' <-> ');
        const name = dataEntry[0];
        const population = Number(dataEntry[1]);

        if (towns[name] == undefined) {
            towns[name] = population;
        } else {
            towns[name] += population;
        }

    }
    for (const entry in towns) {
        console.log(`${entry} : ${towns[entry]}`);
    }
}

townPopulation(['Sofia <-> 1200000',
    'Montana <-> 20000',
    'New York <-> 10000000',
    'Washington <-> 2345000',
    'Las Vegas <-> 1000000']
);

townPopulation(['Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000']
);