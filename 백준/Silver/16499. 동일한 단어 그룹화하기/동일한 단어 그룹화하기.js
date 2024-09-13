let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

const n = input[0];
let set = new Set();

for(let i = 1; i <= n; i++) {
    let checkWord = input[i]
    let checkWordArr = checkWord.split("");
    checkWordArr.sort();
    let sortedCheckWord = checkWordArr.join("");
    
    if(!set.has(sortedCheckWord)) {
        set.add(sortedCheckWord);
    }
}

console.log(set.size);