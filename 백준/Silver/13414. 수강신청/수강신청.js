let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

let temp = input[0].split(" ");
const k = Number(temp[0]);
const l = Number(temp[1]);

let studentMap = new Map();

for (let i = 1; i <= l; i++) {
    studentMap.set(input[i], i);
}

let sortedStudent = Array.from(studentMap).sort((a, b) => a[1] - b[1]);

for(let i = 0; i < Math.min(k, sortedStudent.length); i++) {
    console.log(sortedStudent[i][0]);
}