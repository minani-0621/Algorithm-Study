let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const n = Number(input[0]);
let ringMap = new Map();
let coupleCount = 0;
let answer = [];

for(let i = 1; i <= n; i++) {
    let [name, ring] = input[i].split(" ");
    
    if(ring !== "-") {
        if(!ringMap.has(ring)) {
            ringMap.set(ring, []);
        }
        
        ringMap.get(ring).push(name);
    }
}

ringMap.forEach((name) => {
    if(name.length === 2) {
        coupleCount++;
        answer.push(name.join(" "));
    }
})

console.log(coupleCount);

for(let i = 0; i < coupleCount; i++) {
    console.log(answer[i]);
}