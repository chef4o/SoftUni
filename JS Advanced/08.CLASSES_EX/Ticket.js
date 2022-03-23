function solve(tickets, criteria) {
    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }

    const moviesDb = [];

    tickets.forEach(ticket => {
        const [dstn, amount, stat] = ticket.split("|");
        moviesDb.push(new Ticket(dstn, Number(amount), stat));
    });

    if (criteria == 'destination') {
        moviesDb.sort((a, b) => a.destination.localeCompare(b.destination));
    } else if (criteria == 'price') {
        moviesDb.sort((a, b) => a.price - b.price);
    } else if (criteria = 'status') {
        moviesDb.sort((a, b) => a.status.localeCompare(b.status));
    }
    return moviesDb;
}

console.log(solve(['Philadelphia|94.20|available',
'New York City|95.99|available',
'New York City|95.99|sold',
'Boston|126.20|departed'],
'destination'));