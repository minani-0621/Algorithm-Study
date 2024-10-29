let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, k] = input[0].split(" ").map(Number);
let sArray = input[1].split(" ").map(Number);
const dArray = input[2].split(" ").map(Number);

for(let i = 0; i < k; i++) {
    let map = new Map();
    
    for(let i = 0; i < n; i++) {
        map.set(dArray[i], sArray[i]);
    }
    
    sArray.length = 0;
    
    for(let i = 1; i <= n; i++) {
        sArray.push(map.get(i));
    }
}

sArray.forEach((item) => {
    process.stdout.write(item + " ");
})