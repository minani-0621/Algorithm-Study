let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
let matrix = [];

for(let i = 1; i <= n; i++) {
    matrix.push(input[i].split(" ").map(Number));
}

for(let i = 0; i < n; i++) {
    for(let j = 1; j < n; j++) {
        matrix[i][j] += matrix[i][j - 1];
    }
}

for(let j = 0; j < n; j++) {
    for(let i = 1; i < n; i++) {
        matrix[i][j] += matrix[i - 1][j];
    }
}

for(let i = n + 1; i <= n + m; i++) {
    const [x1, y1, x2, y2] = input[i].split(" ").map(Number);
    
    if(x1 === 1 && y1 === 1) {
        console.log(matrix[x2 - 1][y2 - 1]);
    }else {
        if(x1 === 1 && y1 !== 1) {
            console.log(matrix[x2 - 1][y2 - 1] - matrix[x2 - 1][y1 - 2]);
        }else if(x1 !== 1 && y1 === 1) {
            console.log(matrix[x2 - 1][y2 - 1] - matrix[x1 - 2][y2 - 1]);
        }else {
            console.log(matrix[x2 - 1][y2 - 1] - matrix[x2 - 1][y1 - 2] - matrix[x1 - 2][y2 - 1] + matrix[x1 - 2][y1 - 2]);
        }
        
    }
}