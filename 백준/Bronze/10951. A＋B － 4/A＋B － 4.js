let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

for(let i = 0; i < input.length - 1; i++) {
    let oneCase = input[i].split(" ");
    let sum = Number(oneCase[0]) + Number(oneCase[1]);
    console.log(sum);
}