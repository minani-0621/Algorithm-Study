let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

let n = Number(input);

if(n !== 1) {
    while(n > 1) {
        for(let i = 2; i <= n; i++) {
            if(n % i === 0) {
                console.log(i);
                n /= i;
                break;
            }
        }
    }
}