function sortByTwo(arr) {
    arr.sort((a, b) => {
        if (a.length - b.length != 0) {
            return a.length - b.length;
        } else {
            return a.localeCompare(b);
        }
    });
    console.log(arr.join('\n'));
}

sortByTwo(['alpha',
    'beta',
    'gamma']
);
sortByTwo(['Isacc',
    'Theodor',
    'Jack',
    'Harrison',
    'George']
);
sortByTwo(['test',
    'Deny',
    'omen',
    'Default']
);