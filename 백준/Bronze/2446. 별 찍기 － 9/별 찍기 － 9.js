let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

let n = Number(input);

for(let i = 0; i < 2 * n - 1; i++) {
    if(i < n) {
        for(let j = 0; j < i; j++) {
            process.stdout.write(" ");
        }
        for(let j = 2 * i; j < 2 * n - 1; j++) {
            process.stdout.write("*");
        }
        
        console.log();
    }else {
        for(let j = 2 * n - i - 2; j > 0; j--) {
            process.stdout.write(" ");
        }
        
        for(let j = 2 * n - 1; j < 2 * i + 2; j++) {
            process.stdout.write("*");
        }
        
        console.log();
    }
}