class SummerCamp {

    constructor(organizer, location) {
        this.organizer = organizer,
            this.location = location,
            this.priceForTheCamp = {
                "child": 150,
                "student": 300,
                "collegian": 500
            },
            this.listOfParticipants = [];
    }

    registerParticipant(name, condition, money) {
        if (!this.priceForTheCamp[condition]) {
            throw new Error(`Unsuccessful registration at the camp.`);
        }

        let isRegistered = this.checkIfPresent(name);

        if (isRegistered) {
            return `The ${name} is already registered at the camp.`;
        }

        if (Number(money) < this.priceForTheCamp[condition]) {
            isRegistered = false;
            return `The money is not enough to pay the stay at the camp.`;
        }

        const participant = {
            name: name,
            condition: condition,
            power: 100,
            wins: 0
        }
        this.listOfParticipants.push(participant);
        return `The ${participant.name} was successfully registered.`
    }

    unregisterParticipant(name) {
        let isRegistered = false;
        for (let index = 0; index < this.listOfParticipants.length; index++) {
            if (this.listOfParticipants[index].name == name) {
                isRegistered = true;
                this.listOfParticipants.splice(index, 1);
                break;
            }
        }

        if (!isRegistered) {
            throw new Error(`The ${name} is not registered in the camp.`)
        }

        this.listOfParticipants
        return `The ${name} removed successfully.`;
    }

    timeToPlay(typeOfGame, participant1, participant2) {

        let isRegistered = this.checkIfPresent(participant1);
        if (!isRegistered) {
            throw new Error(`Invalid entered name/s.`);
        }

        if (participant2 == undefined) {  //Game Battleship

            const player = this.listOfParticipants.find(p => p.name == participant1);
            player.power += 20;
            return `The ${player.name} successfully completed the game ${typeOfGame}.`;

        } else { //Game WaterBalloonFights 

            let isRegistered = this.checkIfPresent(participant2);
            if (!isRegistered) {
                throw new Error(`Invalid entered name/s.`);
            }
            const player1 = this.listOfParticipants.find(p => p.name == participant1);
            const player2 = this.listOfParticipants.find(p => p.name == participant2);
            
            if (player1.condition != player2.condition) {
                throw new Error(`Choose players with equal condition.`);
            }
            
            if (player1.power > player2.power) {
                player1.wins += 1;
                return `The ${player1.name} is winner in the game ${typeOfGame}.`;
            } else if (player1.power < player2.power) {
                player2.wins += 1;
                return `The ${player2.name} is winner in the game ${typeOfGame}.`;
            } else {
                return `There is no winner.`;
            }
        }
    }

    checkIfPresent(input) {
        let isPresent = false;
        this.listOfParticipants.forEach(p => {
            if (p.name == input) {
                isPresent = true;
            }
        });

        return isPresent;
    }

    toString() {
        let output = `${this.organizer} will take ${this.listOfParticipants.length} participants on camping to ${this.location}\n`
        this.listOfParticipants
            .sort((a, b) => b.wins - a.wins)
            .forEach(p => output += `${p.name} - ${p.condition} - ${p.power} - ${p.wins}\n`);
        return output.trim();
    }
}

// const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 200));
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
// console.log(summerCamp.registerParticipant("Leila Wolfe", "childd", 200));

// const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
// console.log(summerCamp.unregisterParticipant("Petar"));
// console.log(summerCamp.unregisterParticipant("Petar Petarson"));

// const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
// console.log(summerCamp.timeToPlay("Battleship", "Petar Petarson"));
// console.log(summerCamp.registerParticipant("Sara Dickinson", "child", 200));
// console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Sara Dickinson"));
// console.log(summerCamp.registerParticipant("Dimitur Kostov", "student", 300));
// console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Dimitur Kostov"));

const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
console.log(summerCamp.timeToPlay("Battleship", "Petar Petarson"));
console.log(summerCamp.registerParticipant("Sara Dickinson", "child", 200));
//console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Sara Dickinson"));
console.log(summerCamp.registerParticipant("Dimitur Kostov", "student", 300));
console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Dimitur Kostov"));
console.log(summerCamp.toString());

