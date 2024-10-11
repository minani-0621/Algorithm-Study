let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

let n = Number(input);

for(let i = 0; i < 2 * n - 1; i++) {
    if(i === 0 || i === 2 * n - 2) {
        for(let j = 0; j < n; j++) {
            process.stdout.write("*");
        }
        
        for(let j = 0; j < 2 * n - 3; j++) {
            process.stdout.write(" ");
        }
        
        for(let j = 0; j < n; j++) {
            process.stdout.write("*");
        }
        
        console.log();
    }else if(i === n - 1) {
        for(let j = 0; j < i; j++) {
            process.stdout.write(" ");
        }
        
        process.stdout.write("*");
        
        for(let j = 0; j < n - 2; j++) {
            process.stdout.write(" ");
        }
        
        process.stdout.write("*");
        
        for(let j = 0; j < n - 2; j++) {
            process.stdout.write(" ");
        }
        
        process.stdout.write("*");
        console.log();
    }else {
        if(i < n - 1) {
            for(let j = 0; j < i; j++) {
                process.stdout.write(" ");
            }
        }else {
            for(let j = i; j < 2 * n - 2 ; j++) {
                process.stdout.write(" ");
            }
        }
        
        process.stdout.write("*");
        
        for(let j = 0; j < n - 2; j++) {
            process.stdout.write(" ");
        }
        
        process.stdout.write("*");
        
        if(i < n - 1) {
            for(let j = 2 * (n - i) - 3; j > 0; j--){
                process.stdout.write(" ");
            }
        }else {
            for(let j = 0; j < 2 * (i - n) + 1; j++) {
                process.stdout.write(" ");
            }
        }
        
        process.stdout.write("*");
        
        for(let j = 0; j < n - 2; j++) {
            process.stdout.write(" ");
        }
        
        process.stdout.write("*");
        console.log();
    }
}