let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

const [x, y] = input.split(" ");

let reverseX = x.split("").reverse().join("");
let reverseY = y.split("").reverse().join("");

let sum = Number(reverseX) + Number(reverseY);

let answer = Number(sum.toString().split("").reverse().join(""));

console.log(answer);