const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ').map(Number);


const firstTeam = input[1] + input[2];
const secondTeam = input[0] + input[3];

const answer = Math.abs(firstTeam - secondTeam);
console.log(answer);