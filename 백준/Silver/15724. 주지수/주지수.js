let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const populationMap = [];

for(let i = 1; i <= n; i++) {
    populationMap.push(input[i].split(" ").map(Number));
}

for(let i = 0; i < n; i++) {
    for(let j = 1; j < m; j++) {
        populationMap[i][j] += populationMap[i][j - 1];
    }
}

for(let i = 1; i < n; i++) {
    for(let j = 0; j < m; j++) {
        populationMap[i][j] += populationMap[i - 1][j];
    }
}

const k = Number(input[n + 1]);

for(let i = 0; i < k; i++) {
    let [x1, y1, x2, y2] = input[n + 2 + i].split(" ").map(Number);
    
    if(x1 === 1 && y1 === 1) {
        console.log(populationMap[x2 - 1][y2 - 1]);
    }else if(x1 === 1) {
        console.log(populationMap[x2 - 1][y2 - 1] - populationMap[x2 - 1][y1 - 2]);
    }else if(y1 === 1) {
        console.log(populationMap[x2 - 1][y2 - 1] - populationMap[x1 - 2][y2 - 1]);
    }else {
        console.log(populationMap[x2 - 1][y2 - 1] - populationMap[x2 - 1][y1 - 2] - populationMap[x1 - 2][y2 - 1] + populationMap[x1 - 2][y1 - 2]);
    }
}