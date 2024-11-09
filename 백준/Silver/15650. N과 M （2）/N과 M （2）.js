let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);

function recursion(n, m, start, selected) {
    if(selected.length === m) {
        console.log(selected.join(" "));
    }else if(selected.length < m) {
        for(let i = start; i <= n; i++) {
            recursion(n, m, i + 1, selected.concat(i));
        }
    }
}

recursion(n, m, 1, []);