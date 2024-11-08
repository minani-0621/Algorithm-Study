let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const n = Number(input[0]);
const k = Number(input[1]);
const cards = [];
const set = new Set();

for(let i = 2; i <= n + 1; i++) {
    cards.push(Number(input[i]));
}

function pickCard(n, k, selected, selectedIndex) {
    if(selected.length === k) {
        let newNum = selected.join("");
        
        if(!set.has(newNum)) {
            set.add(newNum);
        }
    }else if(selected.length < k) {
        for(let i = 0; i < n; i++) {
            if(!selectedIndex.includes(i)) {
                pickCard(n, k, selected.concat(cards[i]), selectedIndex.concat(i));
            }
        }
    }
}

pickCard(n, k, [], []);
console.log(set.size);