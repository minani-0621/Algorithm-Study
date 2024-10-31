let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, k] = input[0].split(" ").map(Number);
let temperature = input[1].split(" ").map(Number);

let prefixSum = [temperature[0]];
let temp = temperature[0];

for(let i = 1; i < n; i++) {
    temp += temperature[i];
    prefixSum.push(temp);
}

let periodTemp = [];

for(let i = 0; i <= n - k; i++) {
    if(i === 0) {
        periodTemp.push(prefixSum[i + k - 1]);
    }else {
        periodTemp.push(prefixSum[i + k - 1] - prefixSum[i - 1]);
    }
}

periodTemp.sort((a, b) => b - a);

console.log(periodTemp[0]);