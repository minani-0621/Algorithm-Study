let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

let n = Number(input);

for(let i = 0; i < n; i++) {
    for(let j = 0; j < i; j++) {
        process.stdout.write(" ");
    }
    for(let j = i; j < 2 * n - 1 - i; j++) {
        process.stdout.write("*");
    }
    console.log("");
}