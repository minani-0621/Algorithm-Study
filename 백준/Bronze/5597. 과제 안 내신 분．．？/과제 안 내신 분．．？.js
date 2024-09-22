let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

let studentSet = new Set();

for(let i = 0; i < 28; i++) {
    studentSet.add(Number(input[i]));
}

for(let i = 1; i <= 30; i++) {
    if(!studentSet.has(i)) {
        console.log(i);
    }
}