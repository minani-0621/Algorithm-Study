let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let n = input[0];
let passwords = [];

for (let i = 1; i < input.length; i++) {
  if (input[i] !== '') {
    passwords.push(input[i]);
  }
}

for(let i = 0; i < passwords.length; i++) {
    if(passwords[i].length >= 6 && passwords[i].length <= 9){
        console.log("yes");
    }else {
        console.log("no");
    }
}