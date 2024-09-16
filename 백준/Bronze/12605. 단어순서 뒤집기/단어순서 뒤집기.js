let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

let n = Number(input[0]);
let stack = [];

for(let i = 1; i <= n; i++) {
    let oneString = input[i].split(" ");
    let switchingString = [];
    let answer;
    
    for(let j = oneString.length - 1; j >= 0; j--) {
        switchingString.push(oneString[j]);
        answer = switchingString.join(" ");
    }
    
    console.log("Case #" + i + ": " + answer);
}