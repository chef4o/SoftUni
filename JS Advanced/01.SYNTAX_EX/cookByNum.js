function cookByNum(...args) {
    let [entryNum, ...commands] = args;

    let chop = (number) => {
        return number / 2;
    }
    let dice = function (number) {
        return Math.sqrt(number);
    }
    let spice = function (number) {
        return number + 1;
    }
    let bake = function (number) {
        return number * 3;
    }
    let fillet = function (number) {
        return number *= (1 - 20 / 100);
    }

    let output = entryNum;
    for (let index = 0; index < commands.length; index++) {
        switch (commands[index]) {
            case 'chop':
                output = chop(output);
                break;
            case 'dice':
                output = dice(output);
                break;
            case 'spice':
                output = spice(output);
                break;
            case 'bake':
                output = bake(output);
                break;
            case 'fillet':
                output = fillet(output);
                break;
        }
        console.log(output);
    }
}

cookByNum('32', 'chop', 'chop', 'chop', 'chop', 'chop');
cookByNum('9', 'dice', 'spice', 'chop', 'bake', 'fillet');