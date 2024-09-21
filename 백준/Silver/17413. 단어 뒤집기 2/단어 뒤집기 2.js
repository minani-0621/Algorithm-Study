let fs = require('fs');
let input = fs.readFileSync(0, 'utf-8').toString().trim();

let index = 0;
let answer = "";
let stack = [];

while(index < input.length) {
    if(input[index] === "<") {
        answer = answer.concat(stack.reverse().join(""));
        stack = [];
        let queue = [];
        queue.push(input[index]);
        index++;
        
        while(input[index] !== ">") {
            queue.push(input[index]);
            index++;
        }
        
        queue.push(input[index]);
        index++;
        
        answer = answer.concat(queue.join(""));
    }else {
        if(input[index] === " ") {
            answer = answer.concat(stack.reverse().join("")).concat(" ");
            index++;
            stack = [];
        }else {
            stack.push(input[index]);
            index++;
        }
        
    }
}

if(stack.length !== 0) {
    answer = answer.concat(stack.reverse().join(""));
}

console.log(answer);