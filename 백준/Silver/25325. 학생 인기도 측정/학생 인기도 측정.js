let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const totalStudent = Number(input[0]);
let map = new Map();

const students = input[1].split(" ");

for(let i = 0; i < totalStudent; i++) {
    map.set(students[i], 0);
}

for(let i = 2; i < input.length; i++) {
    let oneCase = input[i].split(" ");
    
    for(let j = 0; j < oneCase.length; j++) {
        map.set(oneCase[j], map.get(oneCase[j]) + 1);
    }
}

let sortedStudent = [...map.entries()].sort((a, b) => {
    if(b[1] === a[1]) {
        return a[0].localeCompare(b[0]);
    }else {
        return b[1] - a[1];
    }
});

for(let i = 0; i < sortedStudent.length; i++) {
    console.log(sortedStudent[i][0] + " " + sortedStudent[i][1]);
}