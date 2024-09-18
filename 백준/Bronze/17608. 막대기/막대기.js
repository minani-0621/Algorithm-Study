let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

const n = Number(input[0]);
let stack = [];

for(let i = 1; i <= n; i++) {
    stack.push(Number(input[i]));
}

let count = 1;
let lookingStick = stack.pop();

for(let i = n - 2; i >= 0; i--) {
    let leftStick = stack.pop();
    
    if(leftStick > lookingStick) {
        lookingStick = leftStick;
        count++;
    }
}

console.log(count);