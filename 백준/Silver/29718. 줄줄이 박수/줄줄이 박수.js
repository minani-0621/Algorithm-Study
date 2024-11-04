let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const a = Number(input[n + 1])
const matrix = [];

for(let i = 1; i <= n; i++) {
    matrix.push(input[i].split(" ").map(Number));
}

const prefixSum = [];

for(let i = 0; i < n; i++) {
    let sum = 0;
    let array = [];
    
    for(let j = 0; j < m; j++) {
        sum += matrix[i][j]
        array.push(sum);
    }
    
    prefixSum.push(array);
}

let maxClap = 0;

for(let i = 0; i < m - a + 1; i++) {
    let count = 0;
    
    for(let j = 0; j < n; j++) {
        if(i === 0) {
            count += prefixSum[j][i + a - 1];
        }else {
            count += prefixSum[j][i + a - 1] - prefixSum[j][i - 1];
        }
    }
    
    maxClap = Math.max(maxClap, count);
}

console.log(maxClap);