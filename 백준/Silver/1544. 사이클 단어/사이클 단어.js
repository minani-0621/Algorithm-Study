let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const n = Number(input[0]);
let wordSet = new Set();

for(let i = 1; i <= n; i++) {
    let word = input[i];
    let exist = false;
    
    wordSet.forEach((value) => {
        for(let i = 0; i < word.length; i++) {
            if(word.slice(i).concat(word.slice(0, i)) === value) {
                exist = true;
            }
        }
    })
    
    if(exist === false) {
        wordSet.add(word);
    }
}

console.log(wordSet.size)