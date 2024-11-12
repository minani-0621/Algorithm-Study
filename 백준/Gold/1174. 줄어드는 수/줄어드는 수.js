let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

const n = Number(input);
const arr = [];

function findDecreasingNum(selected) {
    arr.push(Number(selected.join("")));
    
    for(let i = 0; i <= 9; i++) {
        if(i < selected[selected.length - 1]) {
            findDecreasingNum(selected.concat(i))
        }
    }
}

for(let i = 0; i <= 9; i++) {
    findDecreasingNum([i]);
}

arr.sort((a, b) => a - b);

if(arr.length < n) {
    console.log(-1);
}else {
    console.log(arr[n - 1]);
}