function radar(speed, area) {
    
    let areaLimit;
    switch (area) {
        case 'motorway':
            areaLimit = 130;
            break;
        case 'interstate':
            areaLimit = 90;
            break;
        case 'city':
            areaLimit = 50;
            break;
        case 'residential':
            areaLimit = 20;
            break;
    }

    let speeding = speed - areaLimit;
    let output;
    if (speeding > 0) {
        function getStatus() {
            if (speeding <= 20) {
                return 'speeding';
            } else if (speeding <= 40) {
                return 'excessive speeding';
            } else {
                return 'reckless driving';
            }
        }
        output = `The speed is ${speeding} km/h faster than the allowed speed of ${areaLimit} - ${getStatus()}`;
    } else {
        output = `Driving ${speed} km/h in a ${areaLimit} zone`;
    }
    
    console.log(output);
}

radar(40, 'city');
radar(21, 'residential');
radar(120, 'interstate');
radar(200, 'motorway');
radar(50, 'motorway');

