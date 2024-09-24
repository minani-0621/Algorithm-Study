let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

let array = [];

for(let i = 0; i < input.length; i++) {
    if(!isNaN(input[i])) {
        array.push(Number(input[i]));
    }else {
        array.push(input[i]);
    }
}

let stack = [];

for(let i = 0; i < array.length; i++) {
    if(!isNaN(array[i])) {
        stack.push(array[i]);
    }else {
        operand2 = stack.pop();
        operand1 = stack.pop();
        
        if(array[i] === "+") {
            result = operand1 + operand2;
        }else if(array[i] === "-") {
            result = operand1 - operand2;
        }else if(array[i] === "*") {
            result = operand1 * operand2;
        }else if(array[i] === "/") {
            result = operand1 / operand2;
        }
        
        stack.push(result);
    }
}

console.log(stack.pop());