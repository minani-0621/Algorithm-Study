let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();
let inputArr = input.split(" ");

const n = Number(inputArr[0]);
const k = Number(inputArr[1]);

let queue = [];

for(let i = 1; i <= n; i++) {
    queue.push(i);
}

let josephusSequence = [];
let index = 0;

while(queue.length !== 0) {
    index = (index + k - 1) % queue.length;
    josephusSequence.push(queue[index]);
    queue.splice(index , 1);
}

console.log(`<${josephusSequence.join(", ")}>`);