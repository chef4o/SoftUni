function takePieces(array, from , to) {
    let startIndex = array.findIndex(element => element === from);
    let endIndex = array.findIndex(element => element === to) + 1;
    return array.slice(startIndex, endIndex);
}

takePieces(['Pumpkin Pie',
'Key Lime Pie',
'Cherry Pie',
'Lemon Meringue Pie',
'Sugar Cream Pie'],
'Key Lime Pie',
'Lemon Meringue Pie'
);
takePieces(['Apple Crisp',
'Mississippi Mud Pie',
'Pot Pie',
'Steak and Cheese Pie',
'Butter Chicken Pie',
'Smoked Fish Pie'],
'Pot Pie',
'Smoked Fish Pie'
);