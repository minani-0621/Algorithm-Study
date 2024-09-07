const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim();
const num = parseInt(input);

for(let i = 0; i < num * 2 - 1; i++) {
    if(i < num) {
        for(let j = 0; j < i + 1; j++) {
            process.stdout.write("*");
        }
        console.log();
    }else {
        for(let j = i; j < num * 2 - 1; j++) {
            process.stdout.write("*");
        }
        console.log();
    }
}
