function cityTaxes(name, population, treasury) {
    const city = {};
    city.name = name;
    city.population = Number(population);
    city.treasury = Number(treasury);
    city.taxRate = 10;
    city.collectTaxes = function () {
        this.treasury += this.population * this.taxRate;
    }
    city.applyGrowth = function (percentage) {
        this.population *= (1 + percentage / 100); 
    }
    city.applyRecession = function (percentage) {
        this.treasury *= (1 - percentage / 100);
    }
    return city;
}

const city = cityTaxes('Tortuga',
7000,
15000
);
console.log(city);

city.collectTaxes();
console.log(city.treasury);
city.applyGrowth(5);
console.log(city.population);
