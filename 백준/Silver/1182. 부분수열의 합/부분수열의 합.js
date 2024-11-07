let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, s] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);
let count = 0;

function subsequenceSum(n, index, length, selected) {
    if(selected.length === length) {
        let sum = 0;
        
        for(let i = 0; i < selected.length; i++) {
            sum += Number(selected[i]);
        }
        if(sum === s){
            count++;
        }
    }else if(selected.length < length) {
        for(let i = index; i < n; i++) {
            subsequenceSum(n, i + 1, length, selected.concat(arr[i]));
        }
    }
}

for(let i = 1; i <= n; i++) {
    subsequenceSum(n, 0, i, []);
}

console.log(count);