let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

let n = Number(input);

for(let i = 0; i < n; i++) {
    for(let j = n - 1 - i; j > 0; j--) {
        process.stdout.write(" ");
    }
    
    for(let j = 0; j < i + 1; j++) {
        process.stdout.write("*");
    }
    
    console.log();
}

for(let i = n - 1; i > 0; i--) {
    for(let j = 0; j < n - i; j++) {
        process.stdout.write(" ");
    }
    
    for(let j = i; j > 0; j--) {
        process.stdout.write("*");
    }
    
    console.log();
}