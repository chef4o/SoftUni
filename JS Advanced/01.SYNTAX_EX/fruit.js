function moneyForFruits(fruit, weigthInGrams, pricePerKilo) {
    let weigthInKilos = weigthInGrams / 1000;
    console.log(`I need $${(weigthInKilos * pricePerKilo).toFixed(2)} to buy ${weigthInKilos.toFixed(2)} kilograms ${fruit}.`);
}

moneyForFruits('orange', 2500, 1.80);