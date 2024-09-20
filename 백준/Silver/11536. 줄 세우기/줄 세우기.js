let fs = require('fs');
let input = fs.readFileSync(0, 'utf-8').toString().split("\n");

const n = Number(input[0]);
let students = [];

for(let i = 1; i <= n; i++) {
    students.push(input[i]);
}

let ascendingStudents = [];
let descendingStudents = [];

for(let i = 0; i < students.length; i++) {
    ascendingStudents.push(students[i]);
    descendingStudents.push(students[i]);
}

ascendingStudents.sort();
descendingStudents.sort().reverse();

if(JSON.stringify(students) === JSON.stringify(ascendingStudents)) {
    console.log("INCREASING");
}else if(JSON.stringify(students) === JSON.stringify(descendingStudents)) {
    console.log("DECREASING");
}else {
    console.log("NEITHER");
}