let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [n1, d1] = input[0].split(" ");
const [n2, d2] = input[1].split(" ");

let newD = Number(d1) * Number(d2);
let newN1 = Number(n1) * Number(d2);
let newN2 = Number(n2) * Number(d1);
let newN = newN1 + newN2;

function gcd(n, m) {
    while(m !== 0) {
        let remain = n % m;
        n = m;
        m = remain;
    }
    
    return n;
}

const gcdNum = gcd(newN, newD);

console.log(newN / gcdNum, newD / gcdNum);