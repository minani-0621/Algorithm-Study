let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

const n = Number(input[0]);

function recursion(n, selected) {
    if(selected.length === n) {
        console.log(selected.join(" "));
    }else if(selected.length < n) {
        for(let i = 1; i <= n; i++) {
            if(!selected.includes(i)) {
                recursion(n, selected.concat(i));
            }
        }
    }
}

recursion(n, []);