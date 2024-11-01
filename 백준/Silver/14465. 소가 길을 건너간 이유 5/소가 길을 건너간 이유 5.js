let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, k, b] = input[0].split(" ").map(Number);
const trafficLights = [];

for(let i = 0; i < n; i++) {
    trafficLights.push(1);
}

for(let i = 1; i <= b; i++) {
    trafficLights[input[i] - 1] = 0;
}

const prefixSum = [trafficLights[0]];

for(let i = 1; i < n; i++) {
    prefixSum.push(prefixSum[i - 1] + trafficLights[i]);
}

let minFix = n;

for(let i = 0; i <= n - k; i++) {
    if(i === 0) {
        minFix = Math.min(k - prefixSum[k - 1], minFix);
    }else {
        minFix = Math.min(k - (prefixSum[i + k - 1] - prefixSum[i - 1]), minFix);
    }
}

console.log(minFix);