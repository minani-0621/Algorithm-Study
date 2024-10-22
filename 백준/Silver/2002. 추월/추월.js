let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const n = Number(input[0]);
const map = new Map();

let count = 0;
let index = 0;
let remainCarSet = new Set();

for(let i = 1; i <= n; i++) {
    map.set(input[i], index);
    remainCarSet.add(input[i]);
    index++;
}

for(let i = n + 1; i < 2 * n + 1; i++) {
    remainCarSet.delete(input[i]);
    let exist = false;
    
    remainCarSet.forEach((car) => {
        if(map.get(input[i]) > map.get(car)) {
            exist = true;
        }
    })
    
    if(exist) {
        count++;
    }
}

console.log(count);