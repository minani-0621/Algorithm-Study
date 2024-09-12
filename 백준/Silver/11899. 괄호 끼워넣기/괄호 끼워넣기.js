let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString();

const stackArray = [];
let count = 0;

for(let i = 0; i < input.length; i++) {
    if(input[i] === "(") {
        stackArray.push("(");
    }else if(input[i] === ")") {
        if(stackArray[stackArray.length - 1] === "(") {
            stackArray.pop();
        }else {
            count++;
        }
    }
}

if(stackArray.size !== 0) {
    count += stackArray.length;
}

console.log(count);