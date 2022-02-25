function createAssemblyLine() {
    return {
        hasClima: (vehicle) => {
            vehicle.temp = 21;
            vehicle.tempSettings = 21;
            vehicle.adjustTemp = function () {
                if (vehicle.temp < vehicle.tempSettings) {
                    vehicle.temp += 1;
                } else if (vehicle.temp > vehicle.tempSettings) {
                    vehicle.temp -= 1;
                }
            };
        },
        hasAudio: (vehicle) => {
            vehicle.currentTrack = null;
            vehicle.nowPlaying = () => {
                if (vehicle.currentTrack != null) {
                    console.log(`Now playing '${vehicle.currentTrack.name}' by ${vehicle.currentTrack.artist}`)
                }
            }
        },
        hasParktronic: (vehicle) => {
            vehicle.checkDistance = (distance) => {
                let outputSound = '';
                if (distance < 0.1) {
                    outputSound = "Beep! Beep! Beep!";
                } else if (distance < 0.25) {
                    outputSound = "Beep! Beep!";
                } else if (distance < 0.5) {
                    outputSound = "Beep!";
                }
                console.log(outputSound);
            }
        }
    };
}


const assemblyLine = createAssemblyLine();
const myCar = {
    make: 'Toyota',
    model: 'Avensis'
};

assemblyLine.hasClima(myCar);
console.log(myCar.temp);
myCar.tempSettings = 18;
myCar.adjustTemp();
console.log(myCar.temp);

console.log('----------------');

assemblyLine.hasAudio(myCar);
myCar.currentTrack = {
    name: 'Never Gonna Give You Up',
    artist: 'Rick Astley'
};
myCar.nowPlaying();

console.log('----------------');

assemblyLine.hasParktronic(myCar);
myCar.checkDistance(0.4);
myCar.checkDistance(0.2);

console.log('----------------');

console.log(myCar);