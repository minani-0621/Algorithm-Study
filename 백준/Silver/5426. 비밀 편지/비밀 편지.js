let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

let testCaseCount = input[0];

for(let i = 1; i <= testCaseCount; i++) {
    let stringSize = input[i].length;
    let mapSize = Math.sqrt(stringSize);
    let array2D = [];
    let index = 0;
    
    for(let j = 0; j < mapSize; j++) {
        array2D[j] = [];
        for(let k = 0; k < mapSize; k++) {
            array2D[j][k] = input[i].charAt(index++);
        }
    }
    
    let decryptedString = [];
    
    for(let j = mapSize - 1; j >= 0; j--) {
        for(let k = 0; k < mapSize; k++) {
            decryptedString.push(array2D[k][j]);
        }
    }
    
    let answer = decryptedString.join("");
    console.log(answer);
}
