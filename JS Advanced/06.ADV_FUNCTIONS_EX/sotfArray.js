function sortOrder(nums, order) {
    return order == 'asc' 
        ? nums.sort((a, b) => a-b) 
        : nums.sort((a, b) => b - a) 
}   


console.log(sortOrder([14, 7, 17, 6, 8], 'asc'));
console.log(sortOrder([14, 7, 17, 6, 8], 'desc'));