let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [r, c] = input[0].split(" ");

let matrix = [];

for(let i = 1; i <= Number(r); i++) {
    matrix.push(input[i].split(""));
}

let wordSet = new Set();

for(let i = 0; i < Number(r); i++) {
    let word = "";
    
    for(let j = 0; j < Number(c); j++) {
        if(matrix[i][j] !== "#") {
            word = word.concat(matrix[i][j]);
        }else {
            if(word.length > 1) {
                wordSet.add(word);
            }
            
            word = ""
        }
    }
    
    if(word.length > 1) {
        wordSet.add(word);
    }
}

for(let i = 0; i < Number(c); i++) {
    let word = "";
    
    for(let j = 0; j < Number(r); j++) {
        if(matrix[j][i] !== "#") {
            word = word.concat(matrix[j][i]);
        }else {
            if(word.length > 1) {
                wordSet.add(word);
            }
            
            word = "";
           
        }
    }
    
    if(word.length > 1) {
        wordSet.add(word);
    }
}

const sortedWord = [...wordSet].sort();

console.log(sortedWord[0]);