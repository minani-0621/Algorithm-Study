let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const n = Number(input[0]);
let drinkList = input[1].split(" ").map(Number);

drinkList.sort((a, b) => a - b);

let totalDrink = drinkList[drinkList.length - 1];

for(let i = drinkList.length - 2; i >= 0; i--) {
    totalDrink += drinkList[i] / 2;
}

console.log(totalDrink);