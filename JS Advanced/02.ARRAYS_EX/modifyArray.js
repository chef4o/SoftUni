function modifyArr(command) {
    let arr = [];
    let num = 0;
    while(command.length > 0) {
        let instr = command.shift();
        if (instr == 'add') {
            arr.push(++num);
        } else if (instr == 'remove') {
            num++;
            arr.pop();
        }
    }
    console.log(arr.length == 0 ? 'Empty' : arr.join('\n'));
}