let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

let totalMinutes = input[0];
let score = 0;
let stackHomework = [];
let stackRemainTime = [];

for(let i = 1; i <= totalMinutes; i++) {
    let array = input[i].split(" ");
    
    if(array[0] === "1") {
        let remainTime = Number(array[2]) - 1;
        
        if(remainTime === 0) {
            score += Number(array[1]);
        }else {
            stackHomework.push(array[1]);
            stackRemainTime.push(remainTime)
        }
    }else if(array[0] === "0") {
        let doingHomework = stackHomework.pop();
        let remainTime = Number(stackRemainTime.pop()) - 1;
        
        if(remainTime === 0) {
            score += Number(doingHomework);
        }else {
            stackHomework.push(doingHomework);
            stackRemainTime.push(remainTime);
        }
    }
}

console.log(score);