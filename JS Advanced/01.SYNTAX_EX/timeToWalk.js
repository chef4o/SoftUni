function timeToWalk(steps, footPrint, speedKmH) {
    let distanceToSchoolInMeters = steps * footPrint;
    let restInSeconds = Math.floor(distanceToSchoolInMeters / 500) * 60;
    let speedInMetersPerSecond = (speedKmH * 1000) / 3600;
    let walkTimeInSeconds = (distanceToSchoolInMeters / speedInMetersPerSecond);
    let totalTimeInSeconds = walkTimeInSeconds + restInSeconds;
    
    let totalHours = Math.floor(totalTimeInSeconds / 3600);
    totalHours = totalHours < 10 ? '0' + totalHours : totalHours;
    let totalMinutes = Math.floor((totalTimeInSeconds - (totalHours * 3600)) / 60);
    totalMinutes =  totalMinutes < 10 ? '0' + totalMinutes : totalMinutes;
    let totalSeconds = Math.round(totalTimeInSeconds - (totalMinutes * 60) - (totalHours * 3600));
    totalSeconds =  totalSeconds < 10 ? '0' + totalSeconds : totalSeconds;
   
    console.log(`${totalHours}:${totalMinutes}:${totalSeconds}`)
}

timeToWalk(40000, 0.60, 5);
timeToWalk(2564, 0.70, 5.5);