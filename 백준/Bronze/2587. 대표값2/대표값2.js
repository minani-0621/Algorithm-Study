let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

input.sort();
let sum = 0;

for(let i = 0; i < input.length; i++) {
    sum += Number(input[i]);
}

let avg = sum / 5;

console.log(avg);
console.log(input[2]);