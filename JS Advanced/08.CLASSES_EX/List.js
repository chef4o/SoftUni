class List {
    constructor() {
        this.content = [];
        this.size = 0;
    }

    add (n) {
        this.content.push(n);
        this.content.sort((a, b) => a - b);
        this.size += 1;
    }

    remove (i) {
        this.outOfBoundCheck(i);
        this.content.splice(i, 1);
        this.size -= 1;
    }

    get (i) {
        this.outOfBoundCheck(i);
        return this.content[i];
    }

    outOfBoundCheck(i) {
        if (i < 0 || i > this.size - 1) {
            throw new Error('Index out of range');    
        }
    }
}

let list = new List();
list.add(5);
list.add(6);
list.add(7);
list.add(7);
console.log(list.get(1));
console.log(list.get(3));
console.log(list.get(2));
list.remove(1);
console.log(list.get(1));
