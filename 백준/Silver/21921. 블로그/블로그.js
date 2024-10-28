let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, x] = input[0].split(" ").map(Number);
const visitArray = input[1].split(" ").map(Number);

let prefixSum = [];
let sum = 0;

for(let i = 0; i < n; i++) {
    sum += visitArray[i];
    prefixSum.push(sum);
}

let periodArray = [];

for(let i = 0; i <= n - x; i++) {
    let startIndex = i;
    let endIndex = i + x - 1;
    
    if(startIndex === 0) {
        periodArray.push(prefixSum[endIndex]);
    }else {
        periodArray.push(prefixSum[endIndex] - prefixSum[startIndex - 1]);
    }
}

let maxVisit = 0;
let periodCount = 1;

for(let i = 0; i < periodArray.length; i++) {
    if(maxVisit < periodArray[i]) {
        maxVisit = periodArray[i];
        periodCount = 1;
    }else if(maxVisit === periodArray[i]) {
        periodCount++;
    }
}

if(maxVisit === 0) {
    console.log("SAD");
}else {
    console.log(maxVisit);
    console.log(periodCount);
}