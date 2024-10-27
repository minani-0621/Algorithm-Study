let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const n = Number(input[0]);
let array = input[1].split(" ").map(Number);
let m = Number(input[2]);

let sum = 0;
let prefixSum = [];

for(let i = 0; i < array.length; i++) {
    sum += array[i];
    prefixSum.push(sum);
}

for(let i = 3; i < m + 3; i++) {
    let [start, end] = input[i].split(" ").map(Number);
    
    if(start === 1) {
        console.log(prefixSum[end - 1]);
    }else {
        console.log(prefixSum[end - 1] - prefixSum[start - 2]);
    }
}