let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString();

const n = Number(input);
let count1 = 0;
let count2 = 0;

function fib(n) {
    if(n === 1 || n === 2) {
        return 1;
    }else {
        return fib(n - 1) + fib(n - 2);
    }
}

let memoization = [0, 1, 1];

function fibonacci(n) {
    for(let i = 3; i <= n; i++) {
        count2++;
        memoization[i] = memoization[i - 1] + memoization[i - 2];
    }
    
    return memoization[n];
}

fibonacci(n);

console.log(memoization[n], count2);