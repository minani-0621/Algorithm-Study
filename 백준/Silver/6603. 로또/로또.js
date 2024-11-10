let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

function pickNum(k, s, start, selected) {
    if(selected.length === 6) {
        console.log(selected.join(" "));
    }else if(selected.length < 6) {
        for(let i = start; i < k; i++) {
            pickNum(k, s, i + 1, selected.concat(s[i]));
        }
    }
}

for(let i = 0; i < input.length - 1; i++) {
    const oneCase = input[i].split(" ");
    const k = Number(oneCase[0]);
    const s = oneCase.slice(1);
    
    pickNum(k, s, 0, []);
    console.log();
}
