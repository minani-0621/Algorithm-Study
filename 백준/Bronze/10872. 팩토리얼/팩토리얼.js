let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

const n = Number(input[0]);
let answer = 1;

if(n !== 0) {
    for(let i = 1; i <= n; i++) {
        answer *= i;
    }
}


console.log(answer);