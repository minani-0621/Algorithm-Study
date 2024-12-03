let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, k] = input[0].split(" ").map(Number);
const exerciseKit = input[1].split(" ").map(Number);
let caseCount = 0;

function exercise(n, k, weight, usedKitIndex) {
    if(usedKitIndex.length === n) {
        caseCount++;
    }else if(usedKitIndex.length < n) {
        for(let i = 0; i < n; i++) {
            if(!usedKitIndex.includes(i)) {
                let nextWeight = weight - k + exerciseKit[i];
                
                if(nextWeight >= 500) {
                    exercise(n, k, nextWeight, usedKitIndex.concat(i));
                }
            }
        }
    }
}

exercise(n, k, 500, []);
console.log(caseCount);