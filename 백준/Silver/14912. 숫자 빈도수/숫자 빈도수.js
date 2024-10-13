let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split(" ");

let n = Number(input[0]);
let d = Number(input[1]);

let freq = 0;

for(let i = 1; i <= n; i++) {
    let array = i.toString().split("");
    
    for(let j = 0; j < array.length; j++) {
        if(Number(array[j]) === d) {
            freq++;
        }
    }
}

console.log(freq);