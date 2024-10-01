let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const n = Number(input[0]);
let studentMap = new Map();
let coupleCount = 0;
let answer = [];

for(let i = 1; i <= n; i++) {
    let [name, ring] = input[i].split(" ");
    
    if(ring !== "-") {
        if(!studentMap.has(ring)) {
            studentMap.set(ring, name);
        }else {
            answer.push(studentMap.get(ring));
            answer.push(name);
            coupleCount++;
        }
    }
}

console.log(coupleCount);

for(let i = 0; i < answer.length; i += 2) {
    console.log(answer[i] + " " + answer[i + 1]);
}