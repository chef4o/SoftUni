function solve(...args) {

    let counts = {};

    args.forEach(arg => {
        console.log(`${typeof (arg)}: ${arg}`);
        if (!counts[typeof (arg)]) {
            counts[typeof (arg)] = 1;
        } else {
            counts[typeof (arg)]++;
        }
    })

    Object.keys(counts).sort((a, b) => counts[b] - counts[a])
        .forEach(k => console.log(`${k} = ${counts[k]}`))
}

solve('cat', 42, function () { console.log('Hello world!'); });
console.log('---------');
solve({ name: 'bob' }, 3.333, 9.999);