let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, s] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);

let minLength = n + 1;
let start = 0, end = 0, sum = 0;

while(end < n) {
    sum += arr[end];
    
    while(sum >= s) {
        minLength = Math.min(minLength, end - start + 1);
        sum -= arr[start];
        start++;
    }
    
    end++;
}

if(minLength === n + 1) {
    console.log(0);
}else {
    console.log(minLength);
}