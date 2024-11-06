let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const payArr = input[1].split(" ").map(Number);
const prefixSum = [payArr[0]];

for(let i = 1; i < n; i++) {
    prefixSum.push(prefixSum[i - 1] + payArr[i]);
}

let maxPay = 0;

for(let i = 0; i < n - m + 1; i++) {
    if(i === 0) {
        maxPay = Math.max(maxPay, prefixSum[i + m - 1]);
    }else {
        maxPay = Math.max(maxPay, prefixSum[i + m - 1] - prefixSum[i - 1]);
    }
}

console.log(maxPay);