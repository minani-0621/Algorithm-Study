let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

let temp = input[0].split(" ");
const n = Number(temp[0]);
const m = Number(temp[1]);
let temp2 = input[1].split(" ");
let array = [];
let prefixSum = [];

for(let i = 0; i < temp2.length; i++) {
    array.push(Number(temp2[i]));
    
    if(i === 0) {
        prefixSum.push(Number(temp2[i]));
    }else {
        prefixSum.push(prefixSum[i - 1] + Number(temp2[i]));
    }
}

let count = 0;

for(let i = 0; i < n; i++) {
    for(let j = i; j < n; j++) {
        if(i === 0) {
            if(prefixSum[j] === m) {
                count++;
            }
        }else {
            if(prefixSum[j] - prefixSum[i - 1] === m) {
                count++;
            }
        }
    }
}

console.log(count);