const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let n, m;
let map = new Map();

rl.on('line', (line) => {
    if (!n && !m) {
        [n, m] = line.split(' ').map(Number);
    } else {
        let word = line.trim();
        if (word.length >= m) {
            map.set(word, (map.get(word) || 0) + 1);
        }
    }
}).on('close', () => {
    let sortedWord = Array.from(map).sort((a, b) => {
        if (b[1] === a[1]) {
            if (b[0].length === a[0].length) {
                return a[0].localeCompare(b[0]);
            }
            return b[0].length - a[0].length;
        }
        return b[1] - a[1];
    });

    console.log(sortedWord.map(x => x[0]).join("\n"));
});
