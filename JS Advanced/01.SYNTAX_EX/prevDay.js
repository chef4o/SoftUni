function prevDay(year, month, day) {
    let entryDate = new Date(year, month -1, day);
    entryDate.setDate(entryDate.getDate() - 1);
    console.log(`${entryDate.getFullYear()}-${entryDate.getMonth() + 1}-${entryDate.getDate()}`);
}

prevDay(2016, 9, 30);
prevDay(2016, 10, 1);