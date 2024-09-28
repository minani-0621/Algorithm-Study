let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

const [n, gameType] = input[0].split(" ");
let gameSet = new Set();
let maxPerson;
let gameCount = 0;

if(gameType === "Y") {
    maxPerson = 2;
}else if(gameType === "F") {
    maxPerson = 3;
}else if(gameType === "O") {
    maxPerson = 4;
}

let playingCount = 1;

for(let i = 1; i <= Number(n); i++) {
    if(!gameSet.has(input[i])) {
        gameSet.add(input[i]);
        playingCount++;
        
        if(playingCount === maxPerson) {
            gameCount++;
            playingCount = 1
        }
    }
}

console.log(gameCount);