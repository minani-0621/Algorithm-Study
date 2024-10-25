let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

const [n, m] = input.split(" ").map(BigInt);

let newN1 = 1n;
let newD1 = 1n;

for(let i = n; i > n - m; i--) {
    newN1 *= i;
}

for(let i = 1n; i <= m; i++) {
    newD1 *= i;
}

console.log((newN1 / newD1).toString());