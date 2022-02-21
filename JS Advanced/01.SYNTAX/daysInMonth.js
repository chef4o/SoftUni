function daysCounter(month, year) {
    let date = new Date(year, month, 0).getDate();
    console.log(date);
}

daysCounter(1, 2012);
daysCounter(2, 2021);