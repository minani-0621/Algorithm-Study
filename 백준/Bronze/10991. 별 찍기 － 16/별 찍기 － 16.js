let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

let n = Number(input);

for(let i = 0; i < n; i++) {
    if(n === 1) {
        console.log("*");
    }else {
        if(i === 0) {
            for(let j = 0; j < n - 1; j++) {
                process.stdout.write(" ");
            }
            
            process.stdout.write("*");
            console.log();
        }else {
            for(let j = n - 1; j > i; j--) {
                process.stdout.write(" ");
            }
            
            process.stdout.write("*");
            
            for(let j = 0; j < i; j++) {
                process.stdout.write(" *");
            }
            
            console.log();
        }
        
    }
}