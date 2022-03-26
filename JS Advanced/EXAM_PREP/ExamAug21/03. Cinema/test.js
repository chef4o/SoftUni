const {cinema } = require('./cinema');
const { expect } = require('chai');

describe('Test cinema methods', () => {

    describe('Test showMovie method', () => {
        it('Returns proper list with a few movies', () => {
            expect(cinema.showMovies(["King Kong", "The Tomorrow War", "Joker"])).to.equal("King Kong, The Tomorrow War, Joker");
        })
        it('Returns proper message for empty list', () => {
            expect(cinema.showMovies([])).to.equal("There are currently no movies to show.");
        })
    })

    describe('Test ticketPrice method', () => {
        it('Returns proper price for Normal projection', () => {
            expect(cinema.ticketPrice("Normal")).to.equal(7.50);
        })
        it('Returns proper price for Premiere projection', () => {
            expect(cinema.ticketPrice("Premiere")).to.equal(12.00);
        })
        it('Returns proper price for Discount projection', () => {
            expect(cinema.ticketPrice("Discount")).to.equal(5.50);
        })
        it('Returns proper message on wrong input', () => {
            expect(() => cinema.ticketPrice("Unavailable").to.throw("Invalid projection type."))
        })
    })

    describe('Test swapSeatsInHall mthod', () => {
        it('Returns proper message on correct input', () => {
            expect(cinema.swapSeatsInHall(1, 6)).to.equal("Successful change of seats in the hall.");
        })

        it('Returns proper message on wrong input', () => {
            expect(cinema.swapSeatsInHall(null, null)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(1, null)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(null, 3)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(2.5, 3)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(2, 3.5)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(2.4, 3.5)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(2, 35)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(25, 5)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(0, 5)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(5, 0)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(0, 0)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(-1, 2)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(1, -2)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(-1, -2)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall("1", 2)).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall("1", "2")).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(1, "2")).to.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(5, 5)).to.equal("Unsuccessful change of seats in the hall.");
        })
    })

})