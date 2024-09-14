let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

let n = Number(input[0]);
let queue= [];
let stack = [];

queue = input[1].split(" ");

let index = 1;
let stopIndex = 0;

while(stopIndex === 0) {
    if(index === n + 1) {
        console.log("Nice");
        stopIndex = 1;
    }else {
        if(queue.length === 0) {
            if(Number(stack[stack.length - 1]) === index) {
                stack.pop();
                index++;
            }else {
                console.log("Sad");
                stopIndex = 1;
            }
        }else {
            if(Number(queue[0]) !== index && Number(stack[stack.length - 1]) !== index) {
                stack.push(queue.shift());
            }else if(Number(queue[0]) === index) {
                queue.shift();
                index++;
            }else if(Number(stack[stack.length - 1]) === index) {
                stack.pop();
                index++;
            }
        }
    }
}
