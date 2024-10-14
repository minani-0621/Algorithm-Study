let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

let answer;

for(let i = 1; i < input.length - 1; i++) {
    for(let j = i + 1; j < input.length; j++) {
        let firstToken = input.substring(0, i).split("").reverse().join("");
        let secondToken = input.substring(i, j).split("").reverse().join("");
        let thirdToken = input.substring(j).split("").reverse().join("");
        
        let newWord = firstToken.concat(secondToken).concat(thirdToken);
        
        if(answer === undefined) {
            answer = newWord;
        }else {
            if(answer > newWord) {
                answer = newWord;
            }
        }
    }
}

console.log(answer);