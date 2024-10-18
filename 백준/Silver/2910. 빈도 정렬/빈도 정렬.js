let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, c] = input[0].split(" ");
let inputArr = input[1].split(" ");

let map = new Map();

for(let i = 0; i < inputArr.length; i++) {
    if(map.get(inputArr[i]) === undefined) {
        map.set(inputArr[i], 1);
    }else {
        map.set(inputArr[i], map.get(inputArr[i]) + 1);
    }
}

const sortedMap = Array.from(map).sort((a, b) => {
    if(a[1] - b[1] !== 0) {
        return b[1] - a[1];
    }else {
        return inputArr.indexOf(a[0]) - inputArr.indexOf(b[0]);
    }
});

let answerArr = "";

sortedMap.forEach(item => {
    for(let i = 0; i < item[1]; i++) {
        answerArr = answerArr.concat(item[0] + " ");
    }
})

console.log(answerArr.trim());