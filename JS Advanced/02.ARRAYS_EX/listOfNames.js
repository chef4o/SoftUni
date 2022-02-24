function sortNames(array) {
 const output = array.sort((a, b) => a.localeCompare(b));
 let orderNum = 1;
 output.forEach(element => {
     console.log(`${orderNum++}.${element}`)
 });
} 

sortNames(["John", "Bob", "Christina", "Ema"]);