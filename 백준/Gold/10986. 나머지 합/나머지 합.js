let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);
const map = new Map();
let count = 0;

for(let i = 0; i < n; i++) {
    if(i === 0) {
        map.set(arr[i] % m, 1);
        
        if(arr[i] % m === 0) {
            count++;
        }
    }else {
        arr[i] = (arr[i] % m + arr[i - 1] % m) % m;
        
        if(arr[i] === 0) {
            count++;
        }
        
        if(map.has(arr[i])) {
            count += map.get(arr[i]);
            map.set(arr[i], map.get(arr[i]) + 1);
        }else {
            map.set(arr[i], 1);
        }
    }
}

console.log(count);